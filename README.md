# querydsl 설정 

#build.gradle에 아래 내용 입력
```
plugins {
	id 'org.springframework.boot' version '2.5.6'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	// querydsl 추가 
	id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10'
	id 'java'
}

group = 'study.querydsl'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	
	// querydsl 추가 시작
	implementation 'com.querydsl:querydsl-jpa'
	implementation 'com.querydsl:querydsl-apt'
	// querydsl 추가 끝
	
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

test {
	useJUnitPlatform()
}

// querydsl 추가 시작 
def querydslDir = "$buildDir/generated/querydsl"

querydsl {
 	library = "com.querydsl:querydsl-apt"
	jpa = true
	querydslSourcesDir = querydslDir
}

sourceSets {
    main.java.srcDir querydslDir
}
configurations {
	querydsl.extendsFrom compileClasspath
}
compileQuerydsl {
	options.annotationProcessorPath = configurations.querydsl
}
// querydsl 추가 끝


```

# 빌드 후 설정
```
3-1. 첫번째 방법

(1) cmd 창을 켜서 프로젝트가 저장되어 있는 폴더 경로로 들어간다. -> 여기서는 D:\workspace(jpa)\shopJpa

(2) .\gradlew build를 실행

(3)  src 밑에 generated폴더가  생성된다.

3-2. 두번째 방법

(1) 이클립스 상단 메뉴에서 window 클릭

(2) Show View -> other -> gradle 검색 -> Gradle Task 클릭

(3) Gradle Task에서 해당 프로젝트를 더블클릭 

(4) build 폴더로 가서 build를 선택 후 마우스 오른쪽 클릭

(5) Run Gradle Tasks를 클릭하면 src 밑에 generated 폴더가 생성된다.

4. 프로젝트에 새로 생긴 generated의 경로를 추가해줘야 사용 가능

 (1) 프로젝트 우클릭 -> Properties ->Java build Path

 (2) Source 탭에서 Add Folder... 클릭

 (3) build 폴더 추가 후 import 참조 변경 후 완성
```