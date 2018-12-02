package io.ymq.example;

import static org.junit.Assert.assertTrue;

import javassist.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("io.ymq.providerMock.DubboInterface");
        CtMethod mthd = null;
        try {
            mthd = CtNewMethod.make("public Integer getInteger() { return null; }", cc);
            cc.addMethod(mthd);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }

    }
}
