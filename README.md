# Design Patterns
<h2> <strong> 1. Creational Pattern </strong> </h2>

<details>
<summary> <strong> 1-1. Singleton Patterns </strong> </summary>

- 설명
	- Singleton pattern은 클래스의 인스턴스화를 제한하고 Java Virtual Machine(JVM)에 클래스의 인스턴스가 하나만 존재하도록 한다.
	- Singleton 클래스는 클래스의 인스턴스를 가져오기 위해 전역 엑세스 지점을 제공해야 한다.
	- Singleton pattern은 로깅, 드라이버 개체, 캐싱 및 스레드 풀에 사용된다.
	- Singleton pattern은 Abstract Factory, Builder, Prototype, Facade 등과 같은 다른 디자인 패턴에서도 사용된다.
- 구현
	- 다른 클래스에서 클래스의 인스턴스화를 제한하는 private constructor
	- 클래스의 유일한 인스턴스인 동일한 클래스의 전용 정적 변수
	- 클래스의 인스턴스를 반환하는 public static mehtod
- 종류
	1. [Eager Initialization Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/BillPughSingleton.java)
		- Eager initialization singleton 클래스의 인스턴스는 클래스 로딩 시 생성된다.
		- Eager initialization의 단점은 클라이언트 응용 프로그램이 메서드를 사용하지 않는 경우에도 메서드가 생성된다는 점이다.
		- 따라서, 클래스가 많은 리소스를 사용하지 않는 경우 사용할 수 있는 접근 방식이다.
		- 전역 엑세스 메서드의 예외 처리 옵션을 제공하지 않는다.
	2. [Static Block Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/StaticBlockSingleton.java)
		- Static block singleton은 클래스의 인스턴스가 예외 처리 옵션은 제공하는 정적 블록에 생성된다는 점을 제외하면 즉시 초기화와 유사하다.
		- Eager initialization와 Block intialization 모두 인스턴스가 사용되기 전에 인스턴스를 생성하므로 사용하기에 가장 좋은 방법은 아니다.
	3. [Lazy Initiallization Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/LazyInitializedSingleton.java)
		- Lazy initiallization singleton 패턴은 전역 액세스 메서드에서 인스턴스를 생성한다.
		- 하지만, 다중 스레드 시스템에서 스레드가 동시에 조건 내에 있으면 서로 다른 스레드가 다른 인스턴스를 얻는 문제가 발생할 수 있다.
	4. [Thread Safe Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ThreadSafeSingleton.java)
		- 스레드로부터 안전한 싱글톤 클래스를 만들기 위해선 전역 엑세스 메서드를 sychronized를 사용하여 동기화 하는 것이다.
		- 하지만, synchronized를 사용하는 것은 비용이 많이 발생하고, 이로 인한 성능 저하 이슈도 발생할 수 있다.
		- 따라서, Double checked locking 방식을 사용하여 메서드단에 synchronized를 사용하지 않고, 메서드 내부에서 사용하는 방법이 효율적이다.
	5. [Bill Pugh Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/BillPughSingleton.java)
		- Java complier의 최적화로 인해 다중 스레드 환경에서 [Double checked locking](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ThreadSafeSingleton.java) 방식을 사용하더라도 Singleton이 보장되지 않을 수 있다.
		[관련자료-University of Maryland](http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html, "University of Maryland - Double Checked Locking")
		- SingletonHelper class는 메모리에 로드되지 않고, 전역 엑세스 메서드를 호출해야 class가 로드되어 싱클톤 클래스를 생성한다.
		- 따라서, Bill pugh singleton 방식은 메모리 측면에서 효과적이며, 동기화가 필요하지 않기 때문에 보다 널리 사용된다.
	6. [Reflection Resistanted Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ReflectionSolveSingleton.java)
		- 위의 모든 Singleton 패턴은 [Reflection](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ReflectionSingletonTest.java)을 통해 파괴할 수 있다.
		- 이 패턴의 경우 [Reflection](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ReflectionSingletonTest.java)에 의해서도 파괴되지 않으며, 
		[Double checked locking](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ThreadSafeSingleton.java) 방식의 한계 또한 극복할 수 있다.
		- 먼저, Default Constructor에서 전역 엑세스 메서드를 통한 instance 생성이 아닌 다른 방식의 instance 생성에 대한 접근을 막는다.
		- 그리고, volatile 을 사용하여 CPU cache가 아닌 Main Memory에 instance를 저장하여 다중 스레드 환경에서도 Singleton을 유지할 수 있다.
			- volatile을 사용하지 않을 경우 각 스레드의 성능상의 이슈로 cache에 변수의 복사본을 가질 수 있다.
			- ex) 두개의 스레드 T1과 T2가 있고, 아직 instance 필드가 초기화 되지 않았으며, 두 스레드가 동시에 getInstance() 메서드를 엑세스 한다고 가정했을 때, T1이 먼저 instance를 할당 하고, T2는 null이 아니기에 스레드의 local cache에 instance 복사본이 존재하게 되면, T2는 이미 초기화되었다고 가정하고 해당 복사본은 instance로 반환한다.
			- 위와 같은 문제가 발생할 가능성이 존재하기 때문에 volatile를 사용한다.
	7. [Enum Singleton](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/EnumSingleton.java)
		- Enum singleton은 [Reflection](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/singleton/ReflectionSingletonTest.java)에도 안전하다.
</details>

<details>
<summary> <strong>1-2. Factory Pattern</strong> </summary>

- 설명: [Factory Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/factory)을 활용하면 객체를 생성할 때 클래스의 종류를 명시하지 않고도 객체를 생성할 수 있다.

- 장점:
	1. Flexibility: 객체 생성에서 유연성을 제공한다. 팩토리 클래스를 변경함으로써 코드의 동작을 변경할 수 있다.
	2. Encapsulation: 객체 생성을 캡슐화하여, 객체 생성의 복잡성을 클라이언트 코드에서 숨긴다.
	3. Code Reusability: 객체 생성을 다른 코드와 분리하여 코드 재사용성을 높인다.
	4. Reduced Coupling: 클라이언트 코드와 객체 생성 코드 간의 결합도를 낮춘다. 즉, 팩토리 클래스를 변경해도 클라이언트 코드에 영향을 미치지 않는다.

- 단점:
	1. Overhead: 추가적인 팩토리 클래스를 생성해야 하므로 오버헤드가 발생할 수 있다.
	2. Complexity: 복잡한 객체 생성 로직이나 다수의 argument를 가진 객체를 생성해야 하는 경우 코드에 복잡성을 높인다.
	3. Lack of Transparency: 객체 생성을 담당하는 팩토리 클래스로부터 생성되는 클래스를 식별하기 어렵다.
</details>

<details>
<summary> <strong>1-3. Abstract Factory Pattern</strong> </summary>

- 설명: [Abstract Factory Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/factory)은 입력에 따른 다른 하위 클래스를 if-else 또는 switch를 사용하는 [Factory Pattern](https://github.com/yuntaeLee/design-patterns/blob/master/creational_patterns/factory/ComputerFactory.java)과는 달리 각 하위 클래스에 대한 factory class를 갖는다. 또한 객체의 생성을 공통 interface로 제공하여 구체적인 타입과는 무관하게 객체를 생성할 수 있다.

- 장점:
	1. Abstraction: [Factory Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/factory)보다 높은 수준의 추상화를 제공하여 클라이언트가 구체적인 클래스를 알 필요 없이 객체를 생성할 수 있다.
	2. Encapsulation: 객체 생성을 캡슐화하여, 객체 생성의 복잡성을 클라이언트 코드에서 숨긴다.
	3. Flexibility: 객체 생성에서 유연성을 제공한다. 팩토리 클래스를 변경함으로써 코드의 동작을 변경할 수 있다.
	4. Separation of Concerns: 객체 생성의 관심사를 코드의 나머지 부분과 분리하여 모듈화 및 재사용성을 높인다.

- 단점:
	1. Overhead, Complexity: Factory Class 자체와 이들이 의존하는 추상 클래스 및 인터페이스와 같은 추가 클래스 생성이 필요하기 때문에 이로인한 오버헤드와 코드 복잡성이 높아진다.
	2. Limited Extensibility: 새로운 제품은 Abstract Factory가 생성할 수 있는 제품 집합에만 고정되어 있기 때문에, 만약 새로운 종류의 제품이 생기면 Abstract Factory의 구현을 변경해야 한다.

</details>

<details>
<summary> <strong>1-4. Builder Pattern</strong> </summary>

- [Builder Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/builder)은 객체에 많은 속성이 포함되어 있을 경우 객체 생성에 대한 복잡성이 증가하게 되는데 객체의 구성을 표현에서 분리하고, 동일한 구성 프로세스가 다른 표현을 만들 수 있도록하여 객체 생성의 복잡성 문제를 해결하였다.

- 구현:
	- 먼저 static inner class를 만든 다음 외부 class의 모든 인수를 Builder class에 동일하게 구성한다.
	- Builder class에는 필요한 모든 속성을 parameter로 포함하는 constructor를 만들어야 한다.
	- Builder class에는 선택적 parameter를 설정하는 메서드가 있어야 하며 선택적 속성을 설정한 후 동일한 Builder 객체를 리턴해야 한다.
	- 마지막 단계는 클라이언트 프로그램에 필요한 객체를 반환하는 build() 메서드를 구현한다. 이를 위해선 Builder class를 parameter로 사용하는 클래스의 private constructor가 존재해야 한다.

- 장점: 
	1. Flexibility: 기본 코드를 수정하지 않고도 구성이 다른 객체를 유연하게 생성할 수 있다.
	2. Encapsulation: 객체의 구성 프로세스를 캡슐화하여 수정 및 유지 관리를 쉽게할 수 있다.
	3. Readability: 구성 프로세스의 각 단계가 수행하는 작업을 명확하게 하여 코드의 가독성을 높인다.

- 단점:
	1. complexity: 추가 클래스 및 메서드들의 생성이 필요하므로 코드의 복잡성이 높아질 수 있다.
	2. memory usage: 구성 프로세스 중에 여러 객체를 생성하므로 더 많은 메모리 사용량이 필요할 수 있다.

</details>

<details>
<summary> <strong>1-4. Prototype Pattern</strong> </summary>

- [Prototype Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/prototype)은 새로운 객체를 생성하는 대신 기존 객체를 복제하여 만들 수 있도록 하는 Design pattern이다.

- Database에서 가져온 데이터를 여러 차례에 걸쳐 각기 다른 방식으로 수정해야하는 요구사항이 생겼다고 가정할 때, [Prototype Pattern](https://github.com/yuntaeLee/design-patterns/tree/master/creational_patterns/prototype)을 사용할 경우 수 차례 Database에서 데이터를 조회할 필요없이 한번의 조회 후 객체를 clone하여 Database의 접근을 최소화할 수 있다는 장점이 있다.

</details>

<br/>

<h2> <strong> 2. Structural Patterns </strong> </h2>

<details>
<summary> <strong>2-1. Adapter Pattern</strong> </summary>


</details>