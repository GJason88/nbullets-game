import java.util.function.BiFunction;
// imports Function functional interface
import java.util.function.Function;
// imports Predicate functional interface
import java.util.function.Predicate;

// interface to represent a generic List
interface IList<T> {
  // returns a filtered IList<T> according the Predicate<T>
  IList<T> filter(Predicate<T> pred);

  // returns an updated IList<T> that applies the Function<T, U> to each item in
  // the IList<IGamePiece>
  <U> IList<U> map(Function<T, U> converter);

  // returns a single result of the BiFunction<T, U, U> being applied to every
  // item in the IList<IGamePiece>
  <U> U fold(BiFunction<T, U, U> converter, U initial);

  // returns an updated IList<IGamePiece> with the supplied IList<T> added to the
  // end
  IList<T> append(IList<T> list);

}