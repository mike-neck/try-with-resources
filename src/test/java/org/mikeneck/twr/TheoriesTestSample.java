package org.mikeneck.twr;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static java.lang.System.out;
import static org.junit.Assume.assumeThat;

/**
 * @author mike
 */
@RunWith(Enclosed.class)
public class TheoriesTestSample {

    @RunWith(Theories.class)
    public static class StringSample {
        @DataPoint public static String firstParam = "mike";
        @DataPoint public static String secondParam = "neck";

        @Theory
        public void test (String first, String second) {
            out.println ("first : " + first + " / second : " + second);
            assertThat(1, is(1));
        }
    }

    @RunWith(Theories.class)
    public static class ComplexTestCase {
        @DataPoints public static int[] ages = {19, 20};
        @DataPoints public static boolean[] results = {false, true};

        @Theory
        public void test (int age, boolean result) {
            assumeThat(age >= 20, is(result));
            assertThat(age + " is grater than 20", age >= 20, is(result));
        }
    }

    @RunWith(Theories.class)
    public static class ExceptionsTest {
        public static class AnimalException extends Exception {}
        public static class 猫Exception extends AnimalException {}
        public static class 犬Exception extends AnimalException {}

        public static enum 鳴き声 {
            ニャー, ワン;
        }

        public static class 動物 {
            動物(鳴き声 グルルー) {}
        }

        public static class 猫 extends 動物 {
            猫(鳴き声 グルルー) throws 猫Exception {
                super(グルルー);
                if (グルルー.equals(鳴き声.ワン)) throw new 猫Exception();
            }
        }

        public static class 犬 extends 動物 {
            犬(鳴き声 グルルー) throws 犬Exception {
                super(グルルー);
                if (グルルー.equals(鳴き声.ニャー)) throw new 犬Exception();
            }
        }

        public static enum Animal {
            CAT {
                @Override
                public 動物 createInstance(鳴き声 howl) throws AnimalException {
                    return new 猫(howl);
                }
            }, DOG {
                @Override
                public 動物 createInstance(鳴き声 howl) throws AnimalException {
                    return new 犬(howl);
                }
            };
            abstract public 動物 createInstance (鳴き声 howl) throws AnimalException;
        }

        @DataPoints
        public static Class <? extends AnimalException>[] exceptions () {
            return new Class[] {
                    犬Exception.class, 猫Exception.class
            };
        }
        @DataPoints
        public static 鳴き声[] howls = 鳴き声.values();

        @Theory
        public void exceptionsTest (Class <? extends AnimalException> exception, 鳴き声 howl) {
            for (Animal animal : Animal.values()) {
                AnimalException animalException = null;
                try {
                    animal.createInstance(howl);
                } catch (AnimalException e) {
                    animalException = e;
                }
                assertThat(1, is(1));
                out.println("test -> construct :" + animal + " / 鳴き声 : " + howl + " / exception : " + animalException + " / expected : " + exception);
            }
        }
    }

    @RunWith(Theories.class)
    public static class TypeSafeTest {
        static class Person {
            private int age;
            private String name;
            Person (int age, String name) {
                this.age = age;
                this.name = name;
            }
            boolean isAdult () {
                return age >= 20;
            }
            public int getAge() {
                return age;
            }
            public String getName() {
                return name;
            }
        }

        static class ExpectedResults {
            Person person;
            boolean result;
            ExpectedResults (Person person, boolean result) {
                this.person = person;
                this.result = result;
            }
        }

        @DataPoints
        public static ExpectedResults[] getParameters () {
            return new ExpectedResults[] {
                    new ExpectedResults(new Person(19, "George"), false),
                    new ExpectedResults(new Person(20, "Smith"), true)
            };
        }

        @Theory
        public void runTest (ExpectedResults expected) {
            assertThat(expected.person.name, expected.person.isAdult(), is(expected.result));
        }
    }
}
