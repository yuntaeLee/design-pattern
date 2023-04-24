# Design Patterns

<details>
<summary> <code> 1. Creational Pattern(생성 패턴) </code> </summary>
<br/>
<details>
<summary> <strong> 1-1. Singleton Pattern(싱글톤 패턴) </strong> </summary>

- 원리
	- Singleton pattern은 클래스의 인스턴스화를 제한하고 Java Virtual Machine(JVM)에 클래스의 인스턴스가 하나만 존재하도록 한다.
	- Singleton 클래스는 클래스의 인스턴스를 가져오기 위해 전역 엑세스 지점을 제공해야 한다.
	- Singleton pattern은 로깅, 드라이버 개체, 캐싱 및 스레드 풀에 사용된다.
	- Singleton pattern은 Abstract Factory, Builder, Prototype, Facade 등과 같은 다른 디자인 패턴에서도 사용된다.
- 구현
	- 다른 클래스에서 클래스의 인스턴스화를 제한하는 private constructor
	- 클래스의 유일한 인스턴스인 동일한 클래스의 전용 정적 변수
	- 클래스의 인스턴스를 반환하는 public static mehtod
- 종류
	1. Eager Initialization Singleton
		- Eager initialization singleton 클래스의 인스턴스는 클래스 로딩 시 생성된다.
		- Eager initialization의 단점은 클라이언트 응용 프로그램이 메서드를 사용하지 않는 경우에도 메서드가 생성된다는 점이다.
		- 따라서, 클래스가 많은 리소스를 사용하지 않는 경우 사용할 수 있는 접근 방식이다.
		- getInstance method의 예외 처리 옵션을 제공하지 않는다.
	2. Static Block Singleton
		- Static block singleton은 클래스의 인스턴스가 예외 처리 옵션은 제공하는 정적 블록에 생성된다는 점을 제외하면 즉시 초기화와 유사하다.
		- Eager initialization와 Block intialization 모두 인스턴스가 사용되기 전에 인스턴스를 생성하므로 사용하기에 가장 좋은 방법은 아니다.
	3. Lazy Initiallization Singleton
		- Lazy initiallization singleton 패턴은 getInstance 메서드에서 인스턴스를 생성한다.
		- 하지만, 다중 스레드 시스템에서 스레드가 동시에 조건 내에 있으면 서로 다른 스레드가 다른 인스턴스를 얻는 문제가 발생할 수 있다.

</details>
</details>