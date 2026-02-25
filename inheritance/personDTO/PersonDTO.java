package inheritance.personDTO;

public class PersonDTO<T> {
  private T data;

  public PersonDTO(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

}
