package hashmap;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by qizhou on 19-1-31.
 */

public class HashMap<K, V> {


    /**
     * 最大容量
     */
    public static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 默认负载因子
     */
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;


    /**
     * 链表 树化阈值
     */
    public static final int TREEIFY_THRESHOLD = 8;

    /**
     * 树 链表化阈值
     */
    public static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 树化后表格最小容量(至少4倍于TREEIFY_THRESHOLD)
     */
    public static final int MIN_TREEIFY_CAPACITY = 64;


    /**
     * 默认初始容量
     */
    public static final int DEFAULT_INITIAL_CAPACITY = 1<<4;


    /**
     * 负责存储的哈希桶(table), 首次使用的时候进行初始化，在必要的时候进行扩容.
     * 分配时，长度总是2的n次幂
     * (在某些操作中可以容忍长度为零，以允许当前不需要的引导机制)
     */
    transient Node<K, V>[] table;


    /**
     * 缓存entrySet
     */
    transient Set<Map.Entry<K, V>> entrySet;

    /**
     * map的size
     */
    transient int size;

    /**
     * HashMao在结构上的修改次数
     * 该字段用于fail-fast策略
     * 就是当使用迭代器时，如果发现语气的modCount与实际不合时跑出ConcurrentModificationException
     */
    transient int modCount;


    /**
     * 下次resize时的哈希桶大小(capacity * load factor).
     *
     * @serial
     */
    int threshold;

    /**
     * hash table的负载因子
     *
     * @serial
     */
    final float loadFactor;


    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        //这里实际上并初始化数组，只是利用上面讲到的tableSizeFor计算了长度
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     * 利用指定的容量和默认负载因子(0.75).构造一个空的HashMap
     *
     * @param initialCapacity 初始化容量
     */
    public HashMap(int initialCapacity) {
        //实际调用的是上面的构造函数
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 利用默认初始容量(16)和默认负载因子(0.75).构造一个空的HashMap
     */
    public HashMap() {
        //其他成员变量都是默认值
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }


    /**
     * 根据给定的Map和默认的初始容量以及默认负载因子构造一个HashMap
     *
     * @param m
     * @throws NullPointerException if the specified map is null
     */
    public HashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        //这个方法放在后面说明
        putMapEntries(m, false);
    }


    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        //如果给定的map是空的话，则不进行其他操作
        if (s > 0) {
            //map不为空
            //如果哈希桶还未初始化
            if (table == null) {
                //pre-size
                //计算相关阈值
                float ft = ((float) s / loadFactor) + 1.0f;
                //计算容量大小
                int t = ((ft < (float) MAXIMUM_CAPACITY) ? (int) ft : MAXIMUM_CAPACITY);
                if (t > threshold) {
                    //这里的计算后，不立即进行初始化/扩容
                    threshold = tableSizeFor(t);
                } else if (s > threshold) {
                    //初始化/扩容
                    resize();
                }
                //存放元素
                for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                    K key = e.getKey();
                    V value = e.getValue();
                    putVal(hash(key), key, value, false, evict);
                }

            }
        }
    }

    /**
     * 将给定的key和value存储到map当中
     * 若容器中已存在该key的话，旧的value会被新的value替代
     */
    public V put(K key, V value) {
        //可以看到这里
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * 如果存在，就不覆盖旧值
     */

    public V putIfAbsent(K key, V value) {
        return putVal(hash(key), key, value, true, true);
    }


    /**
     * 实现Map.put和相关方法
     *
     * @param hash         key的hash
     * @param key          key
     * @param value        value
     * @param onlyIfAbsent 如果为true，不改变旧值
     * @param evict        如果为false，则表将采取creation模式.
     * @return 前一个值，如果没有则返回null
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        //定义相关变量
        Node<K, V>[] tab; //当前的hash表里所有的节点
        Node<K, V> p;//当前最后一个位置节点
        int n, i;
        //如果table未被初始化的话，则调用resize进行初始化
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        //哈希桶下标计算i=(n-1)&hash，并判断桶中该位置有没有元素
        if ((p = tab[i = (n - 1) & hash]) == null) {
            //没有元素，则创建新节点放到该位置
            tab[i] = newNode(hash, key, value, null);
        } else {
            //桶中该位置存在元素
            Node<K, V> e;
            K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k)))) {
                //如果给点节点的hash和key跟桶上找到的节点相等，则将旧的p节点赋值给e
                e = p;
            } else if (p instanceof TreeNode) {
                //如果p节点是树节点(红黑树)
                //插入一个树节点
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
            } else {
                //如果以上两者皆不是，则证明当前链表还未树化
                //根据定位的p节点，进行操作
                for (int binCount = 0; ; ++binCount) {
                    //判断p节点的后续节点是否存在
                    if ((e = p.next) == null) {
                        //不存在则创建一个新节点进行插入
                        p.next = newNode(hash, key, value, null);
                        //链表长度超过树化阈值，则执行树化
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            //树化
                            treeifyBin(tab, hash);
                        break;
                    }
                    //如果p的下一个节点e跟给定节点一致，则跳出循环
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    //把e赋值给p，进行链表遍历
                    p = e;
                }
            }
            //如果e不为null
            if (e != null) { // existing mapping for key
                //获取旧值
                V oldValue = e.value;
                //判断入参条件onlyIfAbsent/旧值是否为null
                if (!onlyIfAbsent || oldValue == null)
                    //将新值赋值给e节点
                    e.value = value;
                //空实现 - 主要是为了linkedHashMap的一些后续处理工作
                afterNodeAccess(e);
                return oldValue;
            }
        }
        //增加modCount - 在上面有给出这个变量的含义
        ++modCount;
        //若达到扩容阈值，则进行扩容
        if (++size > threshold)
            //扩容
            resize();
        //空实现 与 afterNodeAccess同理
        afterNodeInsertion(evict);
        return null;
    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }


    /**
     * 初始化或者是将哈希桶(table)大小加倍。
     * 如果为空，则按threshold分配空间
     * 否则，由于采取2的n次幂扩展，容器中的元素在新table中要么呆在原索引处, 要么有一个2的n次幂的位移
     *
     * @return the table
     */
    final Node<K, V>[] resize() {
        //旧的哈希桶
        Node<K, V>[] oldTab = table;
        //旧的容量/长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //旧的threshold
        int oldThr = threshold;
        //新的相关变量
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                //旧的容量大于等于MAXIMUM_CAPACITY
                //则将threshod赋值为Integer.MAX_VALUE
                threshold = Integer.MAX_VALUE;
                //此时不再进行扩容，返回旧的哈希桶
                return oldTab;
            }
            //新的容量为旧容量的的2倍
            //判断新容量是否小于最大值且旧容量大于默认值
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)
                //对新的threshold赋值(2倍于旧的)
                newThr = oldThr << 1; // double threshold
        }
        //判断旧的threshold
        //这种情况下，初始容量为threshold的
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
            //threshold初始化为0，则表明是使用默认值
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        //判断新的threshold是否为0
        if (newThr == 0) {
            //计算新的threshold，为新的容量*负载因子
            float ft = (float) newCap * loadFactor;
            //进行最大值判断
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int) ft : Integer.MAX_VALUE);
        }
        //将计算出来的threshold赋值到成员变量threshold
        threshold = newThr;
        @SuppressWarnings({"rawtypes", "unchecked"})
        //根据计算的容量新建一个哈希桶
                Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        //成员变量table指向新的哈希桶
        table = newTab;
        //判断旧的哈希桶是否为null
        if (oldTab != null) {
            //下面通过循环来移动将旧哈希桶移动到新的哈希桶
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    //没有后续节点
                    if (e.next == null)
                        //将该节点存放到新的哈希桶
                        //使用的是2的n次幂的扩展(指长度扩为原来2倍)，所以，元素的位置要么是在原位置，要么是在原位置再移动2次幂的位置。

                        //eg.1
                        //扩容前
                        //e.hash   = 8    -> 0000 1000
                        //oldCap-1 = 15   -> 0000 1111&    ->0000 1000
                        //    结果 = 8
                        //扩容后
                        //e.hash   = 8    -> 0000 1000
                        //newCap-1 = 31   -> 0001 1111
                        //           &    -> 0000 1000
                        //    结果 = 8 所以位置不变

                        //eg.2
                        //扩容前
                        //e.hash   = 16   -> 0001 0000
                        //oldCap-1 = 15   -> 0000 1111&    ->0000 0000
                        //    结果 = 0
                        //扩容后
                        //e.hash   = 16   -> 0001 0000
                        //newCap-1 = 31   -> 0001 1111
                        //           &    -> 0001 1000
                        //    结果 = 16
                        //位置移动了0 + 16(2的4次幂，也是原来的容量oldCap)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        //如果是树化后的节点，则进行split
                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        //如果还未树化/没有后续节点
                        //维护顺序
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        //旧链表迁移新链表
                        do {
                            //取出后续节点
                            next = e.next;
                            //这里的e.hash & oldCap 目的是取出高位的1bit来判断是否为0，跟上面的 & (oldCap - 1)不同，这里是取出高位1bit来判断是否需要移动
                            //eg.1
                            // e.hash = 8  -> 0000 1000
                            // oldCap = 16 -> 0001 0000 & -> 0000 0000
//                            结果  =  0
                            //如果为0，不需要移动

                            // e.hash = 16 -> 0001 0000
                            // oldCap = 16 -> 0001 0000 & -> 0001 0000
//                            结果  =  16
                            //如果不为0

                            //不需要移动
                            if ((e.hash & oldCap) == 0) {
                                //不需要移动时，以loHead为首节点，维护链表顺序
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                //需要移动时，以hiHead为首节点，维护链表顺序
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;//最后一个节点的next指向的是自己，所以置为null
                            newTab[j] = loHead;//在新的哈希桶中存放链表
                        }
                        if (hiTail != null) {
                            hiTail.next = null;//同上面
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        //返回新的哈希桶
        return newTab;
    }


    /**
     * 如果存在对应的键值对，则根据对应的key，返回value，否则返回null
     * <p>
     * 更精确点说，如果在该map中，存在一个key跟给定的key相同
     * (同为null，或者调用equal为true)，则返回该key对应的value,否则返回null
     * <p>
     * null返回值不一定表示map没有包含此key的映射
     * 也有可能是映射的value的确是null
     * 可以使用containsKey操作来区分这两种情况（指定的key不存在/key存在但value为null）
     *
     * @see #put(Object, Object)
     */
    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
     * 给定key如果不存在的话，就返回默认值
     */
    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? defaultValue : e.value;
    }

    /**
     * 实现 Map.get 和其他相关方法
     *
     * @param hash key的哈希
     * @param key  key
     * @return the node, or null if none
     */
    final Node<K, V> getNode(int hash, Object key) {
        //相关变量
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;
        //检查哈希桶是否为null，长度是否大于0，计算下标取出元素判断是否为null
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & hash]) != null) {
            //对应的下标存在元素，则证明该key存在映射
            //每次都对元素(链表首节点)进行检查判断
            //如果是要找的节点，则返回
            if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            //如果链表首节点不是要找的，则判断后续节点是否存在
            if ((e = first.next) != null) {
                //后续节点存在的话，判断该链表是否树化过
                if (first instanceof TreeNode)
                    //树化过，则通过红黑树查找节点返回(后续分析)
                    return ((TreeNode<K, V>) first).getTreeNode(hash, key);
                //未进行树化，则从链表中搜索对应节点
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        //如果未搜索到节点，则返回null
        return null;
    }


    /**
     * 如果map中存在指定value，则返回true
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the
     * specified value
     */
    public boolean containsValue(Object value) {
        Node<K, V>[] tab;
        V v;
        //判断哈希桶是否被初始化过
        if ((tab = table) != null && size > 0) {
            //哈希桶循环查询
            for (int i = 0; i < tab.length; ++i) {
                //哈希桶上每个元素，进行循环查询
                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
                    //存在值则返回
                    if ((v = e.value) == value ||
                            (value != null && value.equals(v)))
                        return true;
                }
            }
        }
        return false;
    }




    /**
     * 清空所有键值对映射
     * 调用结束后map将会被置空
     */
    public void clear() {
        Node<K, V>[] tab;
        //操作计数 + 1
        modCount++;
        //判断哈希桶是否已经初始化
        if ((tab = table) != null && size > 0) {
            size = 0;
            //循环清空
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }


    /**
     * 计算关键字key的hashCode()并将Hash高位和地位进行异或(XORs)
     * 这个与HashMap中的Table下标计算有关
     * 哈希桶(table)的长度都是2的n次幂，So,index仅和hash的低n位有关
     * 将高16位和低16进行异或，让高16位参与运算，防止频繁碰撞。
     */
    public final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 如果x的类是C且C实现了Comparable，则返回x的class,否则返回null
     * 如：`class C implements Comparable<C>`的形式
     */
    public Class<?> comparableClassFor(Object x) {
        //判断是否是Comparable实例
        if (x instanceof Comparable) {
            //x的类型
            Class<?> c;
            //x的借口
            Type[] ts;
            //x的实参
            Type[] as;
            //参数类型
            Type t;

            ParameterizedType parameterizedType;

            if ((c = x.getClass()) == String.class) {//bypass checks
                return c;
            }

            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType)
                            && ((parameterizedType = (ParameterizedType) t).getRawType() == Comparable.class)
                            && (as = parameterizedType.getActualTypeArguments()) != null
                            && as.length == 1
                            && as[0] == c) {
                        return c;
                    }
                }
            }
        }
        return null;
    }


    /**
     * 如果x不为null且x的Class为1`kc`,则返回k.compareTo(x)
     * 否则返回0
     */
    @SuppressWarnings({"rawtypes", "unchecked"}) // for cast to Comparable
    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 :
                ((Comparable) k).compareTo(x));
    }


    /**
     * 返回大于等于cap的最小的2的n次幂
     * 超过MAXIMUM_CAPACITY，则返回MAXIMUM_CAPACITY
     * <p>
     * 有点抽象，举个例子，如这里的cap为11
     * n = 11-1=10
     * 10的二进制    -> 0000 1010
     * n |= n >>> 1 -> 0000 1010
     * 0000 0101
     * 0000 1111
     * <p>
     * n |= n >>> 2 -> 0000 1111
     * 0000 0011
     * 0000 1111
     * <p>
     * n |= n >>> 4 -> 0000 1111
     * 0000 0000
     * 0000 1111
     * <p>
     * n |= n >>> 8 -> 0000 1111
     * 0000 0000
     * 0000 1111
     * n |= n >>> 16   0000 1111
     * 0000 0000
     * 0000 1111
     * <p>
     * 此时n的二级制为0000 1111，即15
     * 既不小于0，也不大于MAXIMUN_CAPACITY，所以返回n+1
     * <p>
     * 结果是16，即大于11的且是最小的2的n次幂
     * <p>
     * 具体的原理可以google哈~
     * <p>
     * 膜拜Java大神，膝盖奉上。
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }






    /**
     * 实际存储的值
     *
     * @param <K>
     * @param <V>
     */
    public static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;//hahs

        final K key;//k键
        V value;//v值
        Node<K, V> next;//下一个节点


        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;

        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }


        @Override
        public String toString() {
            return "key = " + key + "\nvalue = " + value;
        }

        /**
         * hashCode
         *
         * @return
         */
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }


        @Override
        public final boolean equals(Object obj) {
            //地址比较
            if (obj == this) {
                return true;
            }
            //是否是map.Entry实例
            if (obj instanceof Map.Entry) {
                //类型转换
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) obj;
                //当key与value都相同的时候，返回true
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }

            return false;
        }
    }

}
