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
package br.com.ppm.commons.extras.pmd;

/**
 * PMD PmdDesign Rulesets
 *
 * @author pedrotoliveira
 */
public final class PmdDesign {

    /**
     * UseUtilityClass: For classes that only have static methods, consider making them utility classes.Note that this
     * doesn’t apply to abstract classes, since their subclasses may well include non-static methods. Also, if you want
     * this class to be a utility class,remember to add a private constructor to prevent instantiation.(Note, that this
     * use was known before PMD 5.1.0 as UseSingleton).
     */
    public static final String UseUtilityClass = "PMD.UseUtilityClass";

    /**
     * SimplifyBooleanReturns: Avoid unnecessary if-then-else statements when returning a boolean. The result of the
     * conditional test can be returned instead.
     */
    public static final String SimplifyBooleanReturns = "PMD.SimplifyBooleanReturns";

    /**
     * SimplifyBooleanExpressions: Avoid unnecessary comparisons in boolean expressions, they serve no purpose and
     * impacts readability.
     */
    public static final String SimplifyBooleanExpressions = "PMD.SimplifyBooleanExpressions";

    /**
     * SwitchStmtsShouldHaveDefault: All switch statements should include a default option to catch any unspecified
     * values.
     */
    public static final String SwitchStmtsShouldHaveDefault = "PMD.SwitchStmtsShouldHaveDefault";

    /**
     * AvoidDeeplyNestedIfStmts: Avoid creating deeply nested if-then statements since they are harder to read and
     * error-prone to maintain.
     */
    public static final String AvoidDeeplyNestedIfStmts = "PMD.AvoidDeeplyNestedIfStmts";

    /**
     * AvoidReassigningParameters: Reassigning values to incoming parameters is not recommended. Use temporary local
     * variables instead.
     */
    public static final String AvoidReassigningParameters = "PMD.AvoidReassigningParameters";

    /**
     * SwitchDensity: A high ratio of statements to labels in a switch statement implies that the switch statement is
     * overloaded. Consider moving the statements into new methods or creating subclasses based on the switch variable.
     */
    public static final String SwitchDensity = "PMD.SwitchDensity";

    /**
     * ConstructorCallsOverridableMethod: Calling overridable methods during construction poses a risk of invoking
     * methods on an incompletely constructed object and can be difficult to debug.It may leave the sub-class unable to
     * construct its superclass or forced to replicate the construction process completely within itself, losing the
     * ability to call super(). If the default constructor contains a call to an overridable method, the subclass may be
     * completely uninstantiable. Note that this includes method calls throughout the control flow graph - i.e., if a
     * constructor Foo() calls a private method bar() that calls a public method buz(), this denotes a problem.
     */
    public static final String ConstructorCallsOverridableMethod = "PMD.ConstructorCallsOverridableMethod";

    /**
     * AccessorClassGeneration: Instantiation by way of private constructors from outside of the constructor’s class
     * often causes the generation of an accessor. A factory method, or non-privatization of the constructor can
     * eliminate this situation. The generated class file is actually an interface. It gives the accessing class the
     * ability to invoke a new hidden package scope constructor that takes the interface as a supplementary parameter.
     * This turns a private constructor effectively into one with package scope, and is challenging to discern.
     */
    public static final String AccessorClassGeneration = "PMD.AccessorClassGeneration";

    /**
     * FinalFieldCouldBeStatic: If a final field is assigned to a compile-time constant, it could be made static, thus
     * saving overhead in each object at runtime.
     */
    public static final String FinalFieldCouldBeStatic = "PMD.FinalFieldCouldBeStatic";

    /**
     * CloseResource: Ensure that resources (like Connection, Statement, and ResultSet objects) are always closed after
     * use.
     */
    public static final String CloseResource = "PMD.CloseResource";

    /**
     * NonStaticInitializer: A non-static initializer block will be called any time a constructor is invoked (just prior
     * to invoking the constructor). While this is a valid language construct, it is rarely used and is confusing.
     */
    public static final String NonStaticInitializer = "PMD.NonStaticInitializer";

    /**
     * DefaultLabelNotLastInSwitchStmt: By convention, the default label should be the last label in a switch statement.
     */
    public static final String DefaultLabelNotLastInSwitchStmt = "PMD.DefaultLabelNotLastInSwitchStmt";

    /**
     * NonCaseLabelInSwitchStatement: A non-case label (e.g. a named break/continue label) was present in a switch
     * statement.This legal, but confusing. It is easy to mix up the case labels and the non-case labels.
     */
    public static final String NonCaseLabelInSwitchStatement = "PMD.NonCaseLabelInSwitchStatement";

    /**
     * OptimizableToArrayCall: Calls to a collection’s toArray() method should specify target arrays sized to match the
     * size of the collection. Initial arrays that are too small are discarded in favour of new ones that have to be
     * created that are the proper size.
     */
    public static final String OptimizableToArrayCall = "PMD.OptimizableToArrayCall";

    /**
     * BadComparison: Avoid equality comparisons with Double.NaN. Due to the implicit lack of representation precision
     * when comparing floating point numbers these are likely to cause logic errors.
     */
    public static final String BadComparison = "PMD.BadComparison";

    /**
     * EqualsNull: Tests for null should not use the equals() method. The ‘==’ operator should be used instead.
     */
    public static final String EqualsNull = "PMD.EqualsNull";

    /**
     * ConfusingTernary: Avoid negation within an “if” expression with an “else” clause. For example, rephrase: if (x !=
     * y) diff(); else same();as: if (x == y) same(); else diff();Most “if (x != y)” cases without an “else” are often
     * return cases, so consistent use of this rule makes the code easier to read. Also, this resolves trivial ordering
     * problems, suchas “does the error case go first?” or “does the common case go first?”.
     */
    public static final String ConfusingTernary = "PMD.ConfusingTernary";

    /**
     * InstantiationToGetClass: Avoid instantiating an object just to call getClass() on it; use the .class public
     * member instead.
     */
    public static final String InstantiationToGetClass = "PMD.InstantiationToGetClass";

    /**
     * IdempotentOperations: Avoid idempotent operations - they have no effect.
     */
    public static final String IdempotentOperations = "PMD.IdempotentOperations";

    /**
     * SimpleDateFormatNeedsLocale: Be sure to specify a Locale when creating SimpleDateFormat instances to ensure that
     * locale-appropriate formatting is used.
     */
    public static final String SimpleDateFormatNeedsLocale = "PMD.SimpleDateFormatNeedsLocale";

    /**
     * ImmutableField: Identifies private fields whose values never change once they are initialized either in the
     * declaration of the field or by a constructor. This helps in converting existing classes to becoming immutable
     * ones.
     */
    public static final String ImmutableField = "PMD.ImmutableField";

    /**
     * UseLocaleWithCaseConversions: When doing String.toLowerCase()/toUpperCase() conversions, use Locales to avoids
     * problems with languages that have unusual conventions, i.e. Turkish.
     */
    public static final String UseLocaleWithCaseConversions = "PMD.UseLocaleWithCaseConversions";

    /**
     * AvoidProtectedFieldInFinalClass: Do not use protected fields in final classes since they cannot be subclassed.
     * Clarify your intent by using private or package access modifiers instead.
     */
    public static final String AvoidProtectedFieldInFinalClass = "PMD.AvoidProtectedFieldInFinalClass";

    /**
     * AssignmentToNonFinalStatic: Identifies a possible unsafe usage of a static field.
     */
    public static final String AssignmentToNonFinalStatic = "PMD.AssignmentToNonFinalStatic";

    /**
     * MissingStaticMethodInNonInstantiatableClass: A class that has private constructors and does not have any static
     * methods or fields cannot be used.
     */
    public static final String MissingStaticMethodInNonInstantiatableClass = "PMD.MissingStaticMethodInNonInstantiatableClass";

    /**
     * AvoidSynchronizedAtMethodLevel: Method-level synchronization can cause problems when new code is added to the
     * method. Block-level synchronization helps to ensure that only the code that needs synchronization gets it.
     */
    public static final String AvoidSynchronizedAtMethodLevel = "PMD.AvoidSynchronizedAtMethodLevel";

    /**
     * MissingBreakInSwitch: Switch statements without break or return statements for each case optionmay indicate
     * problematic behaviour. Empty cases are ignored as these indicate an intentional fall-through.
     */
    public static final String MissingBreakInSwitch = "PMD.MissingBreakInSwitch";

    /**
     * UseNotifyAllInsteadOfNotify: Thread.notify() awakens a thread monitoring the object. If more than one thread is
     * monitoring, then only one is chosen. The thread chosen is arbitrary; thus its usually safer to call notifyAll()
     * instead.
     */
    public static final String UseNotifyAllInsteadOfNotify = "PMD.UseNotifyAllInsteadOfNotify";

    /**
     * AvoidInstanceofChecksInCatchClause: Each caught exception type should be handled in its own catch clause.
     */
    public static final String AvoidInstanceofChecksInCatchClause = "PMD.AvoidInstanceofChecksInCatchClause";

    /**
     * AbstractClassWithoutAbstractMethod: The abstract class does not contain any abstract methods. An abstract class
     * suggests an incomplete implementation, which is to be completed by subclasses implementing the abstract methods.
     * If the class is intended to be used as a base class only (not to be instantiated directly) a protected
     * constructor can be provided prevent direct instantiation.
     */
    public static final String AbstractClassWithoutAbstractMethod = "PMD.AbstractClassWithoutAbstractMethod";

    /**
     * SimplifyConditional: No need to check for null before an instanceof; the instanceof keyword returns false when
     * given a null argument.
     */
    public static final String SimplifyConditional = "PMD.SimplifyConditional";

    /**
     * CompareObjectsWithEquals: Use equals() to compare object references; avoid comparing them with ==.
     */
    public static final String CompareObjectsWithEquals = "PMD.CompareObjectsWithEquals";

    /**
     * PositionLiteralsFirstInComparisons: Position literals first in comparisons, if the second argument is null then
     * NullPointerExceptions can be avoided, they will just return false.
     */
    public static final String PositionLiteralsFirstInComparisons = "PMD.PositionLiteralsFirstInComparisons";

    /**
     * PositionLiteralsFirstInCaseInsensitiveComparisons: Position literals first in comparisons, if the second argument
     * is null then NullPointerExceptions can be avoided, they will just return false.
     */
    public static final String PositionLiteralsFirstInCaseInsensitiveComparisons = "PMD.PositionLiteralsFirstInCaseInsensitiveComparisons";

    /**
     * UnnecessaryLocalBeforeReturn: Avoid the creation of unnecessary local variables
     */
    public static final String UnnecessaryLocalBeforeReturn = "PMD.UnnecessaryLocalBeforeReturn";

    /**
     * NonThreadSafeSingleton: Non-thread safe singletons can result in bad state changes. Eliminate static singletons
     * if possible by instantiating the object directly. Static singletons are usually not needed as only a single
     * instance exists anyway.Other possible fixes are to synchronize the entire method or to use an
     * initialize-on-demand holder * class (do not use the double-check idiom).See Effective Java, item 48.
     */
    public static final String NonThreadSafeSingleton = "PMD.NonThreadSafeSingleton";

    /**
     * SingleMethodSingleton: Some classes contain overloaded getInstance. The problem with overloaded getInstance
     * methods is that the instance created using the overloaded method is not cached and so, for each call and new
     * objects will be created for every invocation.
     */
    public static final String SingleMethodSingleton = "PMD.SingleMethodSingleton";

    /**
     * SingletonClassReturningNewInstance: Some classes contain overloaded getInstance. The problem with overloaded
     * getInstance methods is that the instance created using the overloaded method is not cached and so, for each call
     * and new objects will be created for every invocation.
     */
    public static final String SingletonClassReturningNewInstance = "PMD.SingletonClassReturningNewInstance";

    /**
     * UncommentedEmptyMethodBody: Uncommented Empty Method Body finds instances where a method body does not contain
     * statements, but there is no comment. By explicitly commenting empty method bodies it is easier to distinguish
     * between intentional (commented) and unintentional empty methods.
     */
    public static final String UncommentedEmptyMethodBody = "PMD.UncommentedEmptyMethodBody";

    /**
     * UncommentedEmptyConstructor: Uncommented Empty Constructor finds instances where a constructor does not contain
     * statements, but there is no comment. By explicitly commenting empty constructors it is easier to distinguish
     * between intentional (commented)and unintentional empty constructors.
     */
    public static final String UncommentedEmptyConstructor = "PMD.UncommentedEmptyConstructor";

    /**
     * AvoidConstantsInterface: An interface should be used only to characterize the external behaviour of an
     * implementing class: using an interface as a container of constants is a poor usage pattern and not recommended.
     */
    public static final String AvoidConstantsInterface = "PMD.AvoidConstantsInterface";

    /**
     * UnsynchronizedStaticDateFormatter: SimpleDateFormat instances are not synchronized. Sun recommends using separate
     * format instances for each thread. If multiple threads must access a static formatter, the formatter must be
     * synchronized either on method or block level.
     */
    public static final String UnsynchronizedStaticDateFormatter = "PMD.UnsynchronizedStaticDateFormatter";

    /**
     * PreserveStackTrace: Throwing a new exception from a catch block without passing the original exception into
     * thenew exception will cause the original stack trace to be lost making it difficult to debug effectively.
     */
    public static final String PreserveStackTrace = "PMD.PreserveStackTrace";

    /**
     * UseCollectionIsEmpty: The isEmpty() method on java.util.Collection is provided to determine if a collection has
     * any elements.Comparing the value of size() to 0 does not convey intent as well as the isEmpty() method.
     */
    public static final String UseCollectionIsEmpty = "PMD.UseCollectionIsEmpty";

    /**
     * ClassWithOnlyPrivateConstructorsShouldBeFinal: A class with only private constructors should be final, unless the
     * private constructor is invoked by a inner class.
     */
    public static final String ClassWithOnlyPrivateConstructorsShouldBeFinal = "PMD.ClassWithOnlyPrivateConstructorsShouldBeFinal";

    /**
     * EmptyMethodInAbstractClassShouldBeAbstract: Empty methods in an abstract class should be tagged as abstract. This
     * helps to remove their inappropriate usage by developers who should be implementing their own versions in the
     * concrete subclasses.
     */
    public static final String EmptyMethodInAbstractClassShouldBeAbstract = "PMD.EmptyMethodInAbstractClassShouldBeAbstract";

    /**
     * SingularField: Fields whose scopes are limited to just single methods do not rely on the containing object to
     * provide them to other methods. They may be better implemented as local variables within those methods.
     */
    public static final String SingularField = "PMD.SingularField";

    /**
     * ReturnEmptyArrayRatherThanNull: For any method that returns an array, it is a better to return an empty array
     * rather than a null reference. This removes the need for null checking all results and avoids
     * inadvertentNullPointerExceptions.
     */
    public static final String ReturnEmptyArrayRatherThanNull = "PMD.ReturnEmptyArrayRatherThanNull";

    /**
     * AbstractClassWithoutAnyMethod: If an abstract class does not provides any methods, it may be acting as a simple
     * data container that is not meant to be instantiated. In this case, it is probably better to use a private or
     * protected constructor in order to prevent instantiation than make the class misleadingly abstract.
     */
    public static final String AbstractClassWithoutAnyMethod = "PMD.AbstractClassWithoutAnyMethod";

    /**
     * TooFewBranchesForASwitchStatement: Switch statements are indended to be used to support complex branching
     * behaviour. Using a switch for only a few cases is ill-advised, since switches are not as easy to understand as
     * if-then statements. In these cases use theif-then statement to increase code readability.
     */
    public static final String TooFewBranchesForASwitchStatement = "PMD.TooFewBranchesForASwitchStatement";

    /**
     * LogicInversion: Use opposite operator instead of negating the whole expression with a logic complement operator.
     */
    public static final String LogicInversion = "PMD.LogicInversion";

    /**
     * UseVarargs: Java 5 introduced the varargs parameter declaration for methods and constructors. This syntactic
     * sugar provides flexibility for users of these methods and constructors, allowing them to avoid having to deal
     * with the creation of an array.
     */
    public static final String UseVarargs = "PMD.UseVarargs";

    /**
     * FieldDeclarationsShouldBeAtStartOfClass: Fields should be declared at the top of the class, before any method
     * declarations, constructors, initializers or inner classes.
     */
    public static final String FieldDeclarationsShouldBeAtStartOfClass = "PMD.FieldDeclarationsShouldBeAtStartOfClass";

    /**
     * GodClass: The God Class rule detects the God Class design flaw using metrics. God classes do too many things,are
     * very big and overly complex. They should be split apart to be more object-oriented.The rule uses the detection
     * strategy described in “Object-Oriented Metrics in Practice”.The violations are reported against the entire class.
     * See also the references:Michele Lanza and Radu Marinescu. Object-Oriented Metrics in Practice:Using Software
     * Metrics to Characterize, Evaluate, and Improve the PmdDesign of Object-Oriented Systems. Springer, Berlin, 1
     * edition, October 2006. Page 80.
     */
    public static final String GodClass = "PMD.GodClass";

    /**
     * AvoidProtectedMethodInFinalClassNotExtending: Do not use protected methods in most final classes since they
     * cannot be sub classed. This should only be allowed in final classes that extend other classes with protected
     * methods (whose visibility cannot be reduced). Clarify your intent by using private or package access modifiers
     * instead.
     */
    public static final String AvoidProtectedMethodInFinalClassNotExtending = "PMD.AvoidProtectedMethodInFinalClassNotExtending";

    private PmdDesign() {
    }
}
