plugins {
  kotlin("jvm") version "1.6.21"
  id("org.jetbrains.dokka") version "1.6.10"
  `java-library`
  `maven-publish`
}

group = "io.foxcapades.lib"
version = "1.0.0"

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8

  withSourcesJar()
  withJavadocJar()
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
  useJUnitPlatform()
}

tasks.dokkaHtml {
  outputDirectory.set(file("docs/dokka"))
}

tasks.dokkaJavadoc {
  outputDirectory.set(file("docs/javadoc"))
}

task("docs") {
  dependsOn("dokkaHtml", "dokkaJavadoc")
}

publishing {
  repositories {
    maven {
      name = "GitHub"
      url = uri("https://maven.pkg.github.com/foxcapades/lib-unsigned-atomics")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }

  publications {
    create<MavenPublication>("gpr") {
      from(components["java"])
      pom {
        name.set("Atomic Unsigned Types")
        description.set("Provides atomic wrappers for Kotlin's unsigned types.")
        url.set("https://github.com/foxcapades/lib-unsigned-atomics")
        developers {
          developer {
            id.set("epharper")
            name.set("Elizabeth Paige Harper")
            email.set("epharper@upenn.edu")
            url.set("https://github.com/foxcapades")
            organization.set("VEuPathDB")
          }
        }
        scm {
          connection.set("scm:git:git://github.com/foxcapades/lib-unsigned-atomics.git")
          developerConnection.set("scm:git:ssh://github.com/foxcapades/lib-unsigned-atomics.git")
          url.set("https://github.com/foxcapades/lib-unsigned-atomics")
        }
      }
    }
  }
}
