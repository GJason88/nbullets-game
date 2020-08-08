import java.util.function.BiFunction;
// imports Function functional interface
import java.util.function.Function;
// imports Predicate functional interface
import java.util.function.Predicate;

class ConsList<T> implements IList<T> {
  T first;
  IList<T> rest;

  ConsList(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }

  public IList<T> filter(Predicate<T> pred) {
    if (pred.test(this.first)) {
      return new ConsList<T>(this.first, this.rest.filter(pred));
    }
    else {
      return this.rest.filter(pred);
    }
  }

  public <U> IList<U> map(Function<T, U> converter) {
    return new ConsList<U>(converter.apply(this.first), this.rest.map(converter));
  }

  public <U> U fold(BiFunction<T, U, U> converter, U initial) {
    return converter.apply(this.first, this.rest.fold(converter, initial));
  }

  public IList<T> append(IList<T> list) {
    return new ConsList<T>(this.first, this.rest.append(list));
  }
}

class MtList<T> implements IList<T> {

  MtList() {
  }

  public IList<T> filter(Predicate<T> pred) {
    return new MtList<T>();
  }

  public <U> IList<U> map(Function<T, U> converter) {
    return new MtList<U>();
  }

  public <U> U fold(BiFunction<T, U, U> converter, U initial) {
    return initial;
  }

  public IList<T> append(IList<T> list) {
    return list;
  }
}