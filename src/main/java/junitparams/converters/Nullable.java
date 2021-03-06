
package junitparams.converters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import junitparams.Parameters;

/**
 * Allows test null values defined as a String array in {@link Parameters} 
 * 
 * @author Peter Jurkovic
 * 
 * <p>
 * Example: 
 * <pre>
 * {@literal @}Test
 * {@literal @}Parameters({" null "})
 * public void shouldBeNull({@literal @}Nullable String value) {
 *     assertThat(value).isNull();
 * }
 * </pre>
 * </br>
 * You can also customize null "identifier". See following example
 * </br>
 * <pre><code>
 * {@literal @}Test
 * {@literal @}Parameters({" myNull "})
 * public void shouldBeNull({@literal @}Nullable("myNull") String value) {
 *     assertThat(value).isNull();
 *     // passes
 * }
 * </code></pre>
 * </p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
public @interface Nullable {
    
	static String DEFAULT_NULL_IDENTIFIER = "null"; 
	
	/**
     * Defines parameter value which will be replaced by Java null
     */
	String value() default DEFAULT_NULL_IDENTIFIER;
	
    /**
     * Defines parameter value which will be replaced by Java null
     * <br><br>
     * Use {@code  @Nullable("customNull")} instead
     */
	@Deprecated
    String nullIdentifier() default DEFAULT_NULL_IDENTIFIER;
	
	
}


