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

These wrappers will work the exact same as normal motors / servos, but offer
configurable cached write behaviour. This means that you can just wrap all the
places you get a hardware device with a caching wrapper, and call it a day.

Wrap a motor, or other hardware object, like so:

Java:
```java
DcMotorEx stdMotor = new CachingDcMotorEx(hardwaremap.get(DcMotorEx.class, "motor"));
CachingDcMotorEx cachingMotor = new CachingDcMotorEx(hardwaremap.get(DcMotorEx.class, "motor"));
// these are the same!
// if you store it as a caching motor, you have these extra options:

// get/set the caching tolerance
// the default value for motors is 0.005
// for servos its 0.001
cachingMotor.getCachingTolerance();
cachingMotor.setCachingTolerance(0.005);
// for servos these methods are called setPositionResult and setPostitionRaw
boolean setPower = cachingMotor.setPowerResult(1.0); // returns false if this power write was ignored due to caching
// returns true
boolean setPowerRaw = cachingMotor.setPowerRaw(1.0); // setPowerResult with a temporary caching tolerance of 0
// returns false because 1.0 is what we set last time, if we set 0.99999, it would have returned true
```

Kotlin:
```kt
val stdMotor: DcMotorEx = CachingDcMotorEx(hardwaremap.get(DcMotorEx::class.java, "motor"))
val cachingMotor: CachingDcMotorEx = CachingDcMotorEx(hardwaremap.get(DcMotorEx::class.java, "motor"))
// these are the same!
// if you store it as a caching motor, you have these extra options:

// get/set the caching tolerance
// the default value for motors is 0.005
// for servos its 0.001
cachingMotor.cachingTolerance = 0.005
// for servos these methods are called setPositionResult and setPostitionRaw
val setPower = cachingMotor.setPowerResult(1.0) // returns false if this power write was ignored due to caching
// returns true
val setPowerRaw = cachingMotor.setPowerRaw(1.0) // setPowerResult with a temporary caching tolerance of 0
// returns false because 1.0 is what we set last time, if we set 0.99999, it would have returned true
```

These hardware wrappers are supported:
- CachingCRServo
- CachingServo
- CachingDcMotorSimple
- CachingDcMotor
- CachingDcMotorEx

Each of them has configurable caching tolerances, setResult and setRaw, as shown
in the above examples.
