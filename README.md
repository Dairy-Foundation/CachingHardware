# Installation

1. Repository

Add

```gradle
repositories {
	maven {
		url "https://repo.dairy.foundation/releases"
	}
}
```

To `TeamCode`'s `build.gradle`, above `dependencies`.

2. Implementation

Add the newest version of CachingHardware found
[here](https://repo.dairy.foundation/#/releases/dev/frozenmilk/dairy/CachingHardware) to
the `dependencies` block:

```gradle
depdependencies {
	// ...
	implementation "dev.frozenmilk.dairy:CachingHardware:<MAJ.MIN.ENG>"
	// ...
}
```

The repo will give you the line to add.

3. Sync

Run a gradle sync.

# Usage
Write caching will help to reduce loop times for your robot.

These wrappers will work the exact same as normal motors / servos, but offer configurable cached write behaviour.

Wrap a motor, or other hardware object, like so:

Java:
```java
new CachingDcMotorEx(hardwaremap.get(DcMotorEx.class, "motor"));
```

Kotlin:
```kt
CachingDcMotorEx(hardwaremap.get(DcMotorEx::class.java, "motor"))
```

These hardware wrappers are supported:
- CachingCRServo
- CachingServo
- CachingDcMotorSimple
- CachingDcMotor
- CachingDcMotorEx

Each of them has configurable caching tolerances.