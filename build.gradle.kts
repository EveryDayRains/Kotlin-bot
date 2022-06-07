import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0-RC"
    application
    kotlin("plugin.serialization") version "1.5.30"
}

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
    maven ("https://jitpack.io")
}
group = "me.livixx"
version = "1.0-SNAPSHOT"



dependencies {
//    testImplementation(kotlin("test"))
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")

    // Dependency Injection
    implementation("org.kodein.di:kodein-di:7.8.0")

    // Discord API
    implementation("net.dv8tion:JDA:4.3.0_299") {
        exclude("club.minnced")
    }
    implementation("com.github.freyacodes:Lavalink-Client:walkyst-SNAPSHOT")
//    compile group: 'com.github.freyacodes', name: 'Lavalink-Client', version: 'x.y.z'

    // Logging
    implementation("org.apache.logging.log4j:log4j-api:2.14.1")
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.1.0")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.14.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("me.livixx.bot.Launcher")
}
//compileJava.options.encoding = "UTF-8"

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}