# Clean Code 14장 - 점진적인 개선
- (소개)
- Args 구현
- Args 1차 초안
- String 인수
- 결론

### (소개)
- 춞발은 좋았으나 확장성이 부족했던 모듈 소개
- 개선하고 정리하는 단계를 거쳐보자
- 명령행 인수의 구문을 분석하는 새로운 유틸리티 *Args*

#### 간단한 예시

```java
public class Main {
  public static void main(String[] args) {
    try {
        Args arg = new Args("l,p#,d*", args);
        boolean logging = arg.getBoolean('l');
        int port = arg.getInt('p');
        String directory = arg.getString('d');
        executeApplication(logging, port, directory);
    } catch (ArgsException e) {
        System.out.println("Argument error: %s\n", e.errorMessage());
    }
  }
}
```

- l은 부울 인수, p는 정수 인수, d는 문자열 인수
- 생성자에서 ArgsException이 발생하지 않는다면 명령행 인수의 구문을 성공적으로 분석했으며 Args 인스턴스에 질의를 던져도 좋다는 말이다.
- 인수 값을 가져오려면 getBoolean, getInteger, getString 등과 같은 메서드를 사용한다.
- 형식 문자열이나 명령행 인수 자체에 문제가 있다면 ArgsException이 발생한다.
- 구체적인 오류를 알아내려면 예외가 제공하는 errorMessage 메서드를 사용한다.

### Args 구현
- chapter14 package