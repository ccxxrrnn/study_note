//这是一个选择器，这里可以配置条件
//Stream<Integer> stream = list.stream().filter(k -> k <= 5 && k >= 2);
Stream<T> filter(Predicate<? super T> predicate);

//在这里可以对数据进行批量处理
//Stream<Integer> stream = list.stream().map(k -> k + 1);
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
IntStream mapToInt(ToIntFunction<? super T> mapper);
LongStream mapToLong(ToLongFunction<? super T> mapper);
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);

//将所有数据进行分开，不只是映射一个流映射流的内容
//Stream<Object> stream = list.stream().map(k -> k.split("")).flatMap(Stream :: of);
// 使可以读
// https://www.cnblogs.com/wangjing666/p/9999666.html
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);

//去除流中重复数据
//TerminalOp<T, LinkedHashSet<T>> reduceOp = ReduceOps.<T, LinkedHashSet<T>>makeRef(LinkedHashSet::new, LinkedHashSet::add,
//                                                                 LinkedHashSet::addAll);
// 利用 LinkedHashSet
//Stream<String> stream = list.stream().distinct();
Stream<T> distinct();


//默认排序 调用每个数组项的toString()转型方法，比较得到的字符串的编码大小，按照最小值在前面，最大值在后面的方式排序。
// 自定义：Stream<String> stream = list.stream().sorted(Comparator.comparingInt(Integer::parseInt));
Stream<T> sorted();
Stream<T> sorted(Comparator<? super T> comparator);

//peek 所有流前加上数据，不对流处理
//Stream<Integer> stream = list.stream().peek(k -> System.out.println("zzzzz"));
Stream<T> peek(Consumer<? super T> action);

//截取一定大小
Stream<T> limit(long maxSize);

//跳过前n个
Stream<T> skip(long n);

//从Stream中依次获取满足条件的元素，直到不满足条件为止结束获取
// Stream<String> stream = list.stream().takeWhile(x -> x.equals("11"));
default Stream<T> takeWhile(Predicate<? super T> predicate) {
	Objects.requireNonNull(predicate);
	return StreamSupport.stream(
			new WhileOps.UnorderedWhileSpliterator.OfRef.Taking<>(spliterator(), true, predicate),
			isParallel()).onClose(this::close);
}

//从Stream中依次删除满足条件的元素，直到不满足条件为止结束删除
default Stream<T> dropWhile(Predicate<? super T> predicate) {
	Objects.requireNonNull(predicate);
	return StreamSupport.stream(
			new WhileOps.UnorderedWhileSpliterator.OfRef.Dropping<>(spliterator(), true, predicate),
			isParallel()).onClose(this::close);
}

//循环
//主要的区别在并行流的处理上
//输出的顺序不一定（效率更高）
void forEach(Consumer<? super T> action);
//输出的顺序与元素的顺序严格一致
void forEachOrdered(Consumer<? super T> action);


//转数组
Object[] toArray();
//若是对象数组，则要在 toArray 里面加上 生产对象数组的方法引用。
// toArray(person[] ::  new).
<A> A[] toArray(IntFunction<A[]> generator);

//U identity   数据类型
// BiFunction<U, ? super T, U> accumulator
// 函数式接口BinaryOperator，继承于BiFunction，Bifunction中有一个apply方法，接收两个参数
//public interface BiFunction<T, U, R> {
//    R apply(T t, U u);//接收两个参数 t 和 u, 返回 R
//}
T reduce(T identity, BinaryOperator<T> accumulator);
Optional<T> reduce(BinaryOperator<T> accumulator);
<U> U reduce(U identity,
			 BiFunction<U, ? super T, U> accumulator,
			 BinaryOperator<U> combiner);


<R> R collect(Supplier<R> supplier,
			  BiConsumer<R, ? super T> accumulator,
			  BiConsumer<R, R> combiner);
<R, A> R collect(Collector<? super T, A, R> collector);


Optional<T> min(Comparator<? super T> comparator);


long count();


boolean anyMatch(Predicate<? super T> predicate);


boolean allMatch(Predicate<? super T> predicate);


boolean noneMatch(Predicate<? super T> predicate);


Optional<T> findAny();

// Static factories

/**
 * Returns a builder for a {@code Stream}.
 *
 * @param <T> type of elements
 * @return a stream builder
 */
public static<T> Builder<T> builder() {
	return new Streams.StreamBuilderImpl<>();
}

/**
 * Returns an empty sequential {@code Stream}.
 *
 * @param <T> the type of stream elements
 * @return an empty sequential stream
 */
public static<T> Stream<T> empty() {
	return StreamSupport.stream(Spliterators.<T>emptySpliterator(), false);
}

/**
 * Returns a sequential {@code Stream} containing a single element.
 *
 * @param t the single element
 * @param <T> the type of stream elements
 * @return a singleton sequential stream
 */
public static<T> Stream<T> of(T t) {
	return StreamSupport.stream(new Streams.StreamBuilderImpl<>(t), false);
}

/**
 * Returns a sequential {@code Stream} containing a single element, if
 * non-null, otherwise returns an empty {@code Stream}.
 *
 * @param t the single element
 * @param <T> the type of stream elements
 * @return a stream with a single element if the specified element
 *         is non-null, otherwise an empty stream
 * @since 9
 */
public static<T> Stream<T> ofNullable(T t) {
	return t == null ? Stream.empty()
					 : StreamSupport.stream(new Streams.StreamBuilderImpl<>(t), false);
}

/**
 * Returns a sequential ordered stream whose elements are the specified values.
 *
 * @param <T> the type of stream elements
 * @param values the elements of the new stream
 * @return the new stream
 */
@SafeVarargs
@SuppressWarnings("varargs") // Creating a stream from an array is safe
public static<T> Stream<T> of(T... values) {
	return Arrays.stream(values);
}

/**
 * Returns an infinite sequential ordered {@code Stream} produced by iterative
 * application of a function {@code f} to an initial element {@code seed},
 * producing a {@code Stream} consisting of {@code seed}, {@code f(seed)},
 * {@code f(f(seed))}, etc.
 *
 * <p>The first element (position {@code 0}) in the {@code Stream} will be
 * the provided {@code seed}.  For {@code n > 0}, the element at position
 * {@code n}, will be the result of applying the function {@code f} to the
 * element at position {@code n - 1}.
 *
 * <p>The action of applying {@code f} for one element
 * <a href="../concurrent/package-summary.html#MemoryVisibility"><i>happens-before</i></a>
 * the action of applying {@code f} for subsequent elements.  For any given
 * element the action may be performed in whatever thread the library
 * chooses.
 *
 * @param <T> the type of stream elements
 * @param seed the initial element
 * @param f a function to be applied to the previous element to produce
 *          a new element
 * @return a new sequential {@code Stream}
 */
public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f) {
	Objects.requireNonNull(f);
	Spliterator<T> spliterator = new Spliterators.AbstractSpliterator<>(Long.MAX_VALUE,
		   Spliterator.ORDERED | Spliterator.IMMUTABLE) {
		T prev;
		boolean started;

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			Objects.requireNonNull(action);
			T t;
			if (started)
				t = f.apply(prev);
			else {
				t = seed;
				started = true;
			}
			action.accept(prev = t);
			return true;
		}
	};
	return StreamSupport.stream(spliterator, false);
}

/**
 * Returns a sequential ordered {@code Stream} produced by iterative
 * application of the given {@code next} function to an initial element,
 * conditioned on satisfying the given {@code hasNext} predicate.  The
 * stream terminates as soon as the {@code hasNext} predicate returns false.
 *
 * <p>{@code Stream.iterate} should produce the same sequence of elements as
 * produced by the corresponding for-loop:
 * <pre>{@code
 *     for (T index=seed; hasNext.test(index); index = next.apply(index)) {
 *         ...
 *     }
 * }</pre>
 *
 * <p>The resulting sequence may be empty if the {@code hasNext} predicate
 * does not hold on the seed value.  Otherwise the first element will be the
 * supplied {@code seed} value, the next element (if present) will be the
 * result of applying the {@code next} function to the {@code seed} value,
 * and so on iteratively until the {@code hasNext} predicate indicates that
 * the stream should terminate.
 *
 * <p>The action of applying the {@code hasNext} predicate to an element
 * <a href="../concurrent/package-summary.html#MemoryVisibility"><i>happens-before</i></a>
 * the action of applying the {@code next} function to that element.  The
 * action of applying the {@code next} function for one element
 * <i>happens-before</i> the action of applying the {@code hasNext}
 * predicate for subsequent elements.  For any given element an action may
 * be performed in whatever thread the library chooses.
 *
 * @param <T> the type of stream elements
 * @param seed the initial element
 * @param hasNext a predicate to apply to elements to determine when the
 *                stream must terminate.
 * @param next a function to be applied to the previous element to produce
 *             a new element
 * @return a new sequential {@code Stream}
 * @since 9
 */
public static<T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) {
	Objects.requireNonNull(next);
	Objects.requireNonNull(hasNext);
	Spliterator<T> spliterator = new Spliterators.AbstractSpliterator<>(Long.MAX_VALUE,
		   Spliterator.ORDERED | Spliterator.IMMUTABLE) {
		T prev;
		boolean started, finished;

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			Objects.requireNonNull(action);
			if (finished)
				return false;
			T t;
			if (started)
				t = next.apply(prev);
			else {
				t = seed;
				started = true;
			}
			if (!hasNext.test(t)) {
				prev = null;
				finished = true;
				return false;
			}
			action.accept(prev = t);
			return true;
		}

		@Override
		public void forEachRemaining(Consumer<? super T> action) {
			Objects.requireNonNull(action);
			if (finished)
				return;
			finished = true;
			T t = started ? next.apply(prev) : seed;
			prev = null;
			while (hasNext.test(t)) {
				action.accept(t);
				t = next.apply(t);
			}
		}
	};
	return StreamSupport.stream(spliterator, false);
}

/**
 * Returns an infinite sequential unordered stream where each element is
 * generated by the provided {@code Supplier}.  This is suitable for
 * generating constant streams, streams of random elements, etc.
 *
 * @param <T> the type of stream elements
 * @param s the {@code Supplier} of generated elements
 * @return a new infinite sequential unordered {@code Stream}
 */
public static<T> Stream<T> generate(Supplier<? extends T> s) {
	Objects.requireNonNull(s);
	return StreamSupport.stream(
			new StreamSpliterators.InfiniteSupplyingSpliterator.OfRef<>(Long.MAX_VALUE, s), false);
}

/**
 * Creates a lazily concatenated stream whose elements are all the
 * elements of the first stream followed by all the elements of the
 * second stream.  The resulting stream is ordered if both
 * of the input streams are ordered, and parallel if either of the input
 * streams is parallel.  When the resulting stream is closed, the close
 * handlers for both input streams are invoked.
 *
 * <p>This method operates on the two input streams and binds each stream
 * to its source.  As a result subsequent modifications to an input stream
 * source may not be reflected in the concatenated stream result.
 *
 * @implNote
 * Use caution when constructing streams from repeated concatenation.
 * Accessing an element of a deeply concatenated stream can result in deep
 * call chains, or even {@code StackOverflowError}.
 *
 * <p>Subsequent changes to the sequential/parallel execution mode of the
 * returned stream are not guaranteed to be propagated to the input streams.
 *
 * @apiNote
 * To preserve optimization opportunities this method binds each stream to
 * its source and accepts only two streams as parameters.  For example, the
 * exact size of the concatenated stream source can be computed if the exact
 * size of each input stream source is known.
 * To concatenate more streams without binding, or without nested calls to
 * this method, try creating a stream of streams and flat-mapping with the
 * identity function, for example:
 * <pre>{@code
 *     Stream<T> concat = Stream.of(s1, s2, s3, s4).flatMap(s -> s);
 * }</pre>
 *
 * @param <T> The type of stream elements
 * @param a the first stream
 * @param b the second stream
 * @return the concatenation of the two input streams
 */
public static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) {
	Objects.requireNonNull(a);
	Objects.requireNonNull(b);

	@SuppressWarnings("unchecked")
	Spliterator<T> split = new Streams.ConcatSpliterator.OfRef<>(
			(Spliterator<T>) a.spliterator(), (Spliterator<T>) b.spliterator());
	Stream<T> stream = StreamSupport.stream(split, a.isParallel() || b.isParallel());
	return stream.onClose(Streams.composedClose(a, b));
}

/**
 * A mutable builder for a {@code Stream}.  This allows the creation of a
 * {@code Stream} by generating elements individually and adding them to the
 * {@code Builder} (without the copying overhead that comes from using
 * an {@code ArrayList} as a temporary buffer.)
 *
 * <p>A stream builder has a lifecycle, which starts in a building
 * phase, during which elements can be added, and then transitions to a built
 * phase, after which elements may not be added.  The built phase begins
 * when the {@link #build()} method is called, which creates an ordered
 * {@code Stream} whose elements are the elements that were added to the stream
 * builder, in the order they were added.
 *
 * @param <T> the type of stream elements
 * @see Stream#builder()
 * @since 1.8
 */
public interface Builder<T> extends Consumer<T> {

	/**
	 * Adds an element to the stream being built.
	 *
	 * @throws IllegalStateException if the builder has already transitioned to
	 * the built state
	 */
	@Override
	void accept(T t);

	/**
	 * Adds an element to the stream being built.
	 *
	 * @implSpec
	 * The default implementation behaves as if:
	 * <pre>{@code
	 *     accept(t)
	 *     return this;
	 * }</pre>
	 *
	 * @param t the element to add
	 * @return {@code this} builder
	 * @throws IllegalStateException if the builder has already transitioned to
	 * the built state
	 */
	default Builder<T> add(T t) {
		accept(t);
		return this;
	}

	/**
	 * Builds the stream, transitioning this builder to the built state.
	 * An {@code IllegalStateException} is thrown if there are further attempts
	 * to operate on the builder after it has entered the built state.
	 *
	 * @return the built stream
	 * @throws IllegalStateException if the builder has already transitioned to
	 * the built state
	 */
	Stream<T> build();

}

