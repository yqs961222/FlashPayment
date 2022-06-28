package com.jesse.collection.collections.util;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.*;

/**
 * The root interface in the collection hierarchy.      集合层次结构中的根接口。
 * A collection represents a group of objects, known as its elements.   集合表示一组对象，称为其元素。
 * Some collections allow duplicate elements and others do not.    有些集合允许重复元素，而其他集合则不允许。
 * Some are ordered and others unordered.     有些是有序的，有些是无序的。
 * The JDK does not provide any direct implementations of this interface:    JDK没有提供这个接口的任何直接实现:
 * it provides implementations of more specific subinterfaces like Set and List.    它提供了更具体的子接口(如Set和List)的实现。
 * This interface is typically used to pass collections around and manipulate them where maximum generality is desired.
 * 此接口通常用于传递集合并在需要最大通用性的地方对其进行操作。
 *
 * Bags or multisets (unordered collections that may contain duplicate elements) should implement this interface directly.
 * Bags或multiset(无序集合，可能包含重复的元素)应该直接实现这个接口。
 *
 * All general-purpose Collection implementation classes    所有通用的Collection实现类
 * (which typically implement Collection indirectly through one of its subinterfaces) should provide two "standard" constructors:   (通常通过其子接口间接实现Collection) 应该提供两个“标准”构造器：
 * a void (no arguments) constructor, which creates an empty collection, and a constructor with a single argument of type Collection,  一个void(无参数)构造函数，它创建一个空集合，另一个构造函数只有一个collection类型的参数，
 * which creates a new collection with the same elements as its argument.     它将创建一个具有与其参数相同元素的新集合。
 * In effect, the latter constructor allows the user to copy any collection, producing an equivalent collection of the desired implementation type.
 * 实际上，后一个构造函数允许用户复制任何集合，生成所需实现类型的等效集合。
 * There is no way to enforce this convention (as interfaces cannot contain constructors)     没有办法强制执行此约定(因为接口不能包含构造函数)
 * but all of the general-purpose Collection implementations in the Java platform libraries comply.   但是Java平台库中的所有通用Collection实现都遵守这一规定。
 *
 * The "destructive" methods contained in this interface, that is, the methods that modify the collection on which they operate,   此接口中包含的“破坏性”方法，即修改其操作对象集合的方法，
 * are specified to throw UnsupportedOperationException if this collection does not support the operation.  指定为在此集合不支持操作时抛出UnsupportedOperationException。
 * If this is the case, these methods may, but are not required to, throw an UnsupportedOperationException if the invocation would have no effect on the collection.
 * 如果是这种情况，如果调用对集合没有影响，这些方法可能抛出UnsupportedOperationException，但不是必须抛出。
 * For example, invoking the addAll(Collection) method on an unmodifiable collection may, but is not required to,
 * throw the exception if the collection to be added is empty.  例如，在不可修改的集合上调用addAll(Collection)方法可以，但不是必须，如果添加的集合为空，则抛出异常。
 *
 * Some collection implementations have restrictions on the elements that they may contain.          有些集合实现对它们可能包含的元素有限制。
 * For example, some implementations prohibit null elements, and some have restrictions on the types of their elements.     例如，有些实现禁止空元素，而有些实现对其元素的类型有限制。
 * Attempting to add an ineligible element throws an unchecked exception, typically NullPointerException or ClassCastException.     试图添加不符合条件的元素会抛出未检查的异常，通常为NullPointerException或ClassCastException。
 * Attempting to query the presence of an ineligible element may throw an exception, or it may simply return false;    试图查询不合格元素的存在可能会抛出异常，或者简单地返回false;
 * some implementations will exhibit the former behavior and some will exhibit the latter.   有些实现会表现出前一种行为，有些会表现出后一种行为。
 * More generally, attempting an operation on an ineligible element whose completion would not result in the insertion of an ineligible element into the collection may throw an exception or it may succeed,
 * at the option of the implementation.   更一般的情况是，尝试对不符合条件的元素执行操作，如果该操作的完成不会导致将不符合条件的元素插入到集合中，则可能会抛出异常，或者根据实现的选择，操作可能会成功。
 * Such exceptions are marked as "optional" in the specification for this interface.   这种异常在该接口的规范中被标记为“可选”。
 *
 * It is up to each collection to determine its own synchronization policy.
 * In the absence of a stronger guarantee by the implementation,
 * undefined behavior may result from the invocation of any method on a collection that is being mutated by another thread;
 * this includes direct invocations, passing the collection to a method that might perform invocations, and using an existing iterator to examine the collection.
 *
 *
 * Many methods in Collections Framework interfaces are defined in terms of the equals method.
 * For example, the specification for the contains(Object o) method says:
 * "returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e))."
 * This specification should not be construed to imply that invoking Collection.contains with a non-null argument o will cause o.equals(e)
 * to be invoked for any element e. Implementations are free to implement optimizations whereby the equals invocation is avoided,
 * for example, by first comparing the hash codes of the two elements.
 * (The Object.hashCode() specification guarantees that two objects with unequal hash codes cannot be equal.)
 * More generally, implementations of the various Collections Framework interfaces are free to take advantage
 * of the specified behavior of underlying Object methods wherever the implementor deems it appropriate.
 *
 * Some collection operations which perform recursive traversal of the collection may fail with an exception
 * for self-referential instances where the collection directly or indirectly contains itself.
 * This includes the clone(), equals(), hashCode() and toString() methods.
 * Implementations may optionally handle the self-referential scenario, however most current implementations do not do so.
 *
 * The default method implementations (inherited or otherwise) do not apply any
 * synchronization protocol.  If a {@code Collection} implementation has a
 * specific synchronization protocol, then it must override default
 * implementations to apply that protocol.
 *
 * @param <E> the type of elements in this collection
 * @see     Set
 * @see     List
 * @see     Map
 * @see     SortedSet
 * @see     SortedMap
 * @see     HashSet
 * @see     TreeSet
 * @see     ArrayList
 * @see     LinkedList
 * @see     Vector
 * @see     Collections
 * @see     Arrays
 * @see     AbstractCollection
 * @since 1.2
 * @Author: Jesse Y
 * @Date: 2022-06-27 16:03
 */
public interface JesCollection<E> extends Iterable<E> {
    /**
     * Returns the number of elements in this collection.
     * If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this collection
     * *@Contract(pure = true)
     */
    int size();

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if this collection contains the specified element.
     * More formally, returns true if and only if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
     *
     * @param o element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this collection.
     * There are no guarantees concerning the order in which the elements are returned
     * (unless this collection is an instance of some class that provides a guarantee).
     *
     * @return an Iterator over the elements in this collection
     */
    Iterator<E> iterator();
}
