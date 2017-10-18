/*
 * Copyright (C) 2017 pedrotoliveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.ppm.commons;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit Tests of class TextStackTraceFormatter
 *
 * @author pedrotoliveira
 */
public class TextStackTraceFormatterTest {

    /**
     * Test of formatToString method, of class TextStackTraceFormatter.
     */
    @Test
    public void testFormatToString() {
        Throwable throwable = new RuntimeException("test format to string");
        String result = new TextStackTraceFormatter().formatToString(throwable);
        String expected = "java.lang.RuntimeException: test format to string\n"
                + "	at br.com.ppm.commons.TextStackTraceFormatterTest.testFormatToString(TextStackTraceFormatterTest.java:36)\n"
                + "	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
                + "	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"
                + "	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"
                + "	at java.lang.reflect.Method.invoke(Method.java:498)\n"
                + "	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)\n"
                + "	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)\n"
                + "	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)\n"
                + "	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)\n"
                + "	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)\n"
                + "	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)\n"
                + "	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)\n"
                + "	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n"
                + "	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n"
                + "	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n"
                + "	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n"
                + "	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n"
                + "	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n"
                + "	at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)\n"
                + "	at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)\n"
                + "	at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)\n"
                + "	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n"
                + "	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n"
                + "	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n"
                + "	at java.lang.reflect.Method.invoke(Method.java:498)\n"
                + "	at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\n"
                + "	at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\n"
                + "	at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\n"
                + "	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\n"
                + "	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\n\n";
        //System.out.println(result);
        assertThat("Expect a string like: ".concat(expected), result, equalTo(expected));
    }

}
