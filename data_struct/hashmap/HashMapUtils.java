package hashmap;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by qizhou on 19-1-31.
 */

public class HashMapUtils {

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
     *
     * 有点抽象，举个例子，如这里的cap为11
     * n = 11-1=10
     * 10的二进制    -> 0000 1010
     * n |= n >>> 1 -> 0000 1010
     *                 0000 0101
     *                 0000 1111
     *
     * n |= n >>> 2 -> 0000 1111
     *                 0000 0011
     *                 0000 1111
     *
     * n |= n >>> 4 -> 0000 1111
     *                 0000 0000
     *                 0000 1111
     *
     * n |= n >>> 8 -> 0000 1111
     *                 0000 0000
     *                 0000 1111
     * n |= n >>> 16   0000 1111
     *                 0000 0000
     *                 0000 1111
     *
     * 此时n的二级制为0000 1111，即15
     * 既不小于0，也不大于MAXIMUN_CAPACITY，所以返回n+1
     *
     * 结果是16，即大于11的且是最小的2的n次幂
     *
     * 具体的原理可以google哈~
     *
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

    public static final int MAXIMUM_CAPACITY = 1<<30;
}
