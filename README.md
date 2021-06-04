# RebbVal
DSL for Validation

## What is RebbVal

Is RebbVal a validation library? Nope, RebbVal is a external DSL for validation. It makes writing validation rules easier and more natural. Since it is more human readable than most of existing validation libraries, it means less bugs.

> A [domain-specific language](https://en.wikipedia.org/wiki/Domain-specific_language) (DSL) is a computer language specialized to a particular application domain.

## Language Support

Currently RebbVal only support Java, in the future We plan to support more languages include:

* Javascript
* C 
* PHP 
* Python3

## Highlights
* Human readable rules like `"not empty"` or `">=15"`
* The ability to combine rules as you wish.
  * `">=18 and <=60"`
  * `"<18 or > 60"`
  * `"<18 or >60 and not(in [20,30,40,50])"`
* Custom your own rules in two ways 
   * Regexs: `"match /\d+/"`
   * Custom validators 
* More than 30 validation rules and keep growing    

## Try RebbVal
Simply create a `RebbVal` object and call `val` function

``` java
// initialize a instance of Rebb Val
RebbVal v = new RebbVal();

// validates the input (100) is greater than 10(>10)
v.val(100,">10") // true

//or, is the input is less than 20?
v.val(100,"<20") //false
```

More validation rules

```java
// if the input is greater than or equal to 18 and less then or equal to 60
v.val(50, "between 18 and 60") // true
// same as previous one, two dots represents a range
v.val(50, "[18..60]") // true

// greater than 18 and less than 60
v.val(60, "(18..60)" // false
// you can combine them
v.val(60, "(18..60]") //true
v.val(18, "[18..60)") //false
```

And you can combine two or more rules with `and` and `or`

```java
v.val(60, ">18 and <60") // false

v.val(60, ">18 or <60") // true
```

[Document](https://willking.gitbook.io/rebb-val/)