package com.jesse.collection.collections;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Resizable-array implementation of the List interface.  List接口的可调整数组实现。
 * Implements all optional list operations, and permits all elements, including null.  实现所有可选的列表操作，并允许所有元素，包括null。
 * In addition to implementing the List interface,     除了实现List接口之外，
 * this class provides methods to manipulate the size of the array that is used internally to store the list.   该类提供了操作数组大小的方法，该数组用于在内部存储列表。
 * (This class is roughly equivalent to Vector, except that it is unsynchronized.)    (这个类大致相当于Vector，只是它不是同步的。)
 *
 * The size, isEmpty, get, set, iterator, and listIterator operations run in constant time.   size、isEmpty、get、set、iterator和listIterator操作的运行时间为常数。
 * The add operation runs in amortized constant time, that is, adding n elements requires O(n) time.  add操作的运行时间平摊为常数，即添加n个元素需要O(n)时间。
 * All of the other operations run in linear time (roughly speaking).     所有其他操作都在线性时间内运行(粗略地说)。
 * The constant factor is low compared to that for the LinkedList implementation.   与LinkedList实现相比，常量因子较低。
 *
 * Each ArrayList instance has a capacity.   每个ArrayList实例都有一个容量。
 * The capacity is the size of the array used to store the elements in the list.  容量是用于存储列表中元素的数组的大小。
 * It is always at least as large as the list size.   它总是至少和列表大小一样大。
 * As elements are added to an ArrayList, its capacity grows automatically.   当向ArrayList添加元素时，它的容量会自动增加。
 * The details of the growth policy are not specified beyond the fact that adding an element has constant amortized time cost.
 * 除了添加一个元素具有恒定的平摊时间成本这一事实之外，没有指定增长策略的详细信息。
 *
 * An application can increase the capacity of an ArrayList instance
 * before adding a large number of elements using the ensureCapacity operation. 应用程序可以增加ArrayList实例的容量在使用ensureCapacity操作添加大量元素之前。
 * This may reduce the amount of incremental reallocation.  这可能会减少增量重新分配的数量。
 *
 * Note that this implementation is not synchronized.    注意，这个实现不是同步的。
 * If multiple threads access an ArrayList instance concurrently,     如果多个线程同时访问一个ArrayList实例，
 * and at least one of the threads modifies the list structurally, it must be synchronized externally.    并且至少有一个线程在结构上修改了列表，它必须在外部同步。
 * (A structural modification is any operation that adds or deletes one or more elements,     (结构修改是添加或删除一个或多个元素的任何操作，
 * or explicitly resizes the backing array; merely setting the value of an element is not a structural modification.)   或显式地调整基础数组的大小; 仅仅设置元素的值并不是结构上的修改。)
 * This is typically accomplished by synchronizing on some object that naturally encapsulates the list.    这通常通过对自然封装列表的某些对象进行同步来完成。
 * If no such object exists, the list should be "wrapped" using the Collections.synchronizedList method.   如果（当前）不存在这样的对象，list应该使用Collections.synchronizedList方法进行“包装”。
 * This is best done at creation time, to prevent accidental unsynchronized access to the list:       这最好在创建时完成，以防止意外的对列表的非同步访问:
 *
 *          List list = Collections.synchronizedList(new ArrayList(...));
 *
 * The iterators returned by this class's iterator and listIterator methods are fail-fast:   这个类的迭代器和listIterator方法返回的迭代器是快速失败的:
 * if the list is structurally modified at any time after the iterator is created,     如果在创建迭代器之后的任何时候列表的结构被修改，
 * in any way except through the iterator's own remove or add methods,          除了通过迭代器自身的remove或add方法之外的任何方法，
 * the iterator will throw a ConcurrentModificationException.          迭代器将抛出ConcurrentModificationException异常。
 * Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,       因此，面对并发修改时，迭代器会快速而干净利落地失败，
 * rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.   而不是在未来的一个不确定的时间冒险进行任意的、不确定的行为。
 *
 * Note that the fail-fast behavior of an iterator cannot be guaranteed as it is,       请注意，不能保证迭代器的快速失败行为，
 * generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.   一般来说，在存在不同步的并发修改时，不可能做出任何硬保证。
 * Fail-fast iterators throw ConcurrentModificationException on a best-effort basis.    快速失败迭代器尽可能抛出ConcurrentModificationException。
 * Therefore, it would be wrong to write a program that depended on this exception for its correctness:   因此，编写依赖于此异常的正确性的程序是错误的:
 * the fail-fast behavior of iterators should be used only to detect bugs.   迭代器的快速失败行为应该只用于检测bug。
 *
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Collection
 * @see     List
 * @see     LinkedList
 * @see     Vector
 * @since   1.2
 *
 * @Author: Jesse Y
 * @Date: 2022-06-27 10:18
 */
public class TestArrayList {






















}
