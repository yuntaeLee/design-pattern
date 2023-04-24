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
	1. [Eager Initialization Singleton](/blob/master/creational_patterns/singleton/BillPughSingleton.java)
		- Eager initialization singleton 클래스의 인스턴스는 클래스 로딩 시 생성된다.
		- Eager initialization의 단점은 클라이언트 응용 프로그램이 메서드를 사용하지 않는 경우에도 메서드가 생성된다는 점이다.
		- 따라서, 클래스가 많은 리소스를 사용하지 않는 경우 사용할 수 있는 접근 방식이다.
		- 전역 엑세스 메서드의 예외 처리 옵션을 제공하지 않는다.
	2. [Static Block Singleton](singleton/StaticBlockSingleton.java)
		- Static block singleton은 클래스의 인스턴스가 예외 처리 옵션은 제공하는 정적 블록에 생성된다는 점을 제외하면 즉시 초기화와 유사하다.
		- Eager initialization와 Block intialization 모두 인스턴스가 사용되기 전에 인스턴스를 생성하므로 사용하기에 가장 좋은 방법은 아니다.
	3. [Lazy Initiallization Singleton](singleton/LazyInitializedSingleton.java)
		- Lazy initiallization singleton 패턴은 전역 액세스 메서드에서 인스턴스를 생성한다.
		- 하지만, 다중 스레드 시스템에서 스레드가 동시에 조건 내에 있으면 서로 다른 스레드가 다른 인스턴스를 얻는 문제가 발생할 수 있다.
	4. [Thread Safe Singleton](singleton/ThreadSafeSingleton.java)
		- 스레드로부터 안전한 싱글톤 클래스를 만들기 위해선 전역 엑세스 메서드를 sychronized를 사용하여 동기화 하는 것이다.
		- 하지만, synchronized를 사용하는 것은 비용이 많이 발생하고, 이로 인한 성능 저하 이슈도 발생할 수 있다.
		- 따라서, Double checked locking 방식을 사용하여 메서드단에 synchronized를 사용하지 않고, 메서드 내부에서 사용하는 방법이 효율적이다.
	5. [Bill Pugh Singleton](singleton/BillPughSingleton.java)
		- Java complier의 최적화로 인해 다중 스레드 환경에서 Double checked locking 방식을 사용하더라도 Singleton이 보장되지 않을 수 있다. [관련자료 - University of Maryland](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html, "University of Maryland - Double Checked Locking")
		- Bill Pugh Singleton 방식은 가장 널리 사용되는 접근 방식이다.
		- SingletonHelper class는 메모리에 로드되지 않고, 전역 엑세스 메서드를 호출해야 class가 로드되어 싱클톤 클래스를 생성한다.
		- 이는 메모리 측면에서 효과적이며, 동기화가 필요하지 않기 때문에 보다 널리 사용된다.
</details>
</details>
