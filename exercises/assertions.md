# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion rate à cause de l'imprécision de calcul sur les float. Pour contrer l'écart, il faut tester l'égalité avec un delta : assertEquals(3*.4, 1.2, 0.0001).

2. `assertEquals` test l'égalité entre les valeurs, `assertSame` test légalité entre les références.
    ```
    Même Résultat :
        int expected = 42;
        int actual = 42;
        assertEquals(expected, actual); //Vrai
        assertSame(expected, actual); //Vrai
    
    Résultat différent :
        String expected = new String("hello");
        String actual = new String("hello");
        assertEquals(expected, actual); //Vrai
        assertSame(expected, actual); //Faux
    ```

3. `fail` peut être utilisé dans le cas où une exception est attendu :
    ```
    @Test
    public void expectedException() {
        try {
            methodThrowsException();
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
    ```

4. Avantages :
- Clarté du test : on sait à quel moment l'exception est levée dans le test
