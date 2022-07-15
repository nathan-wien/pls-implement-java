# Pls Implement - Java

## Introduction

### What is this?

This is a toy project that I created to:

- learn how to setup a Java project with Maven
- learn Property-Based Testing using [`jqwik`](https://jqwik.net/)
- set up a template for data structures and algorithms learning purposes

### How can I use it?

* Clone it.
* Enable the tests.
* Try to pass the tests.
* Try to make the style checker happy.


## Prerequisites

- IntelliJ IDEA
- [`pre-commit`](https://pre-commit.com/#install)
- [`make`](https://www.gnu.org/software/make/) (or curl)
- Java (8 or later - can just install the JDK directly in IntelliJ)
- [Maven](https://maven.apache.org/) (optional; you can use Maven direcly in IntelliJ)

## Setup

After cloning the directory, please do the following:

### Download the style checker

If you have `make`, this is easy (confirm by running `which make`). You just have to run:

```
make
```

Otherwise, use `curl` as follows:

```
curl -L https://github.com/checkstyle/checkstyle/releases/download/checkstyle-${CHECKSTYLE_VERSION}/checkstyle-${CHECKSTYLE_VERSION}-all.jar -o checkstyle.jar
```

### Install pre-commit hook

```
pre-commit install
```

### Setup IntelliJ to format code

* **Enable format on save**: see [here](https://www.jetbrains.com/help/idea/reformat-and-rearrange-code.html#reformat-on-save)
* **Install the CheckStyle-IDEA plugin**: go to `Settings | Plugins`. Restart IntelliJ.
* **Import the style setting file `style.xml` into IntelliJ**: go to `Settings | Editor | Code Style | Java`. Click on the cog icon, choose `Import Scheme | CheckStyle Configuration` and choose the `style.xml` file in the root directory of the repo.

### Check if maven is set up properly

* In IntelliJ, run `mvn verify`.

## FAQs

1. Why Java?

- I happen to encounter Java quite a bit in my day job.

2. Why Property-Based Testing?

- Short answer: I think it is very interesting and very useful at the same time.

3. Why data structures and algorithms?

- Data structures and algorithms almost always have properties to be tested. I just think that this is quite a sensible use
  case for Property-Based Testing.
