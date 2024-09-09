plugins {
	id("com.android.library")
	id("kotlin-android")
	id("org.jetbrains.dokka") version "1.9.10"
	id("maven-publish")
}

android {
	namespace = "dev.frozenmilk.dairy.cachinghardware"
	compileSdk = 29

	defaultConfig {
		minSdk = 24
		//noinspection ExpiredTargetSdkVersion
		targetSdk = 28

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8

		kotlin {
			compilerOptions {
				freeCompilerArgs.add("-Xjvm-default=all")
			}
		}
	}
}

dependencies {
	//noinspection GradleDependency
	implementation("androidx.appcompat:appcompat:1.2.0")

	compileOnly("org.firstinspires.ftc:RobotCore:10.0.0")
	compileOnly("org.firstinspires.ftc:FtcCommon:10.0.0")
}

publishing {
	publications {
		register<MavenPublication>("release") {
			groupId = "dev.frozenmilk.dairy"
			artifactId = "CachingHardware"
			version = "1.0.0"

			afterEvaluate {
				from(components["release"])
			}
		}
	}
	repositories {
		maven {
			name = "Dairy"
			url = uri("https://repo.dairy.foundation/releases")
			credentials(PasswordCredentials::class)
			authentication {
				create<BasicAuthentication>("basic")
			}
		}
	}
}
