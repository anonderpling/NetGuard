# Building NetGuard in Termux (Infinix Hot 40)

This guide explains how to build NetGuard directly on your Android phone using Termux.

## 1) Prerequisites

- Infinix Hot 40 with enough free storage (recommended: 8+ GB free)
- Stable internet connection (Gradle will download dependencies)
- Termux from F-Droid/GitHub release (recommended over Play Store build)

## 2) Install build tools in Termux

```sh
pkg update && pkg upgrade -y
pkg install -y git openjdk-17 wget unzip
```

Check Java:

```sh
java -version
```

## 3) Get the source code

If you already have this repository folder, go to it.  
Otherwise clone:

```sh
git clone https://github.com/Ayanprogrammer11/NetGuard.git
cd NetGuard
```

## 4) Make Gradle wrapper executable

```sh
chmod +x ./gradlew
```

## 5) Build a debug APK (recommended)

```sh
./gradlew assembleDebug
```

Output APK:

`app/build/outputs/apk/debug/NetGuard-debug.apk`

## 6) Install the APK on your phone

From Termux:

```sh
termux-setup-storage
cp app/build/outputs/apk/debug/NetGuard-debug.apk ~/storage/downloads/
```

Then install `NetGuard-debug.apk` from your Downloads folder (allow install from unknown sources when prompted).

## 7) Optional: build other variants

- Play variant:

```sh
./gradlew assemblePlay
```

- Release variant (requires signing config):

Create `keystore.properties` in the project root, then:

```sh
./gradlew assembleRelease
```

## Troubleshooting

- **`Could not resolve ...` / dependency download failures**  
  Check internet connection and retry.

- **Java version errors**  
  Make sure `java -version` shows Java 17.

- **Build too slow / killed**  
  Close other apps and ensure enough free RAM/storage.

- **Permission denied on `gradlew`**  
  Run `chmod +x ./gradlew` again.
