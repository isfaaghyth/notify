# notify
📮 a micro-library to simplifies a simple communication between activity, fragment, services, etc. through reactive-pattern.

### installation
Step 1. Add the JitPack repository to your build file
```javascript
   allprojects {
      repositories {
         ...
         maven { url 'https://jitpack.io' }
      }
   }
```

Step 2. Add the dependency
```javascript
   dependencies {
      implementation 'com.github.isfaaghyth:notify:1.0'
   }
```

### how to use it?

send notify

```java
   Notify.send("Hai")
```

subscriber

```java
  composite.add(Notify.listen(String::class.java, NotifyProvider(), Consumer {
      person -> textView.text = person.name
  }))
```

or with throwable like this

```java
  composite.add(Notify.listen(String::class.java, NotifyProvider(), Consumer {
      person -> textView.text = person.name
  }, Consumer {
      t -> Log.e(TAG, t.message)
  }))
```

cheers!
