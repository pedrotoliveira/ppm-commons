package com.ppm.commons;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Pedro T. Oliveira <pedro.oliveira.nom.br>
 */
public class StackTraceFormatter {

    /**
     * Padrões de formatação das StackTraces em String.
     */
    public enum Format {

        /**
         * HTML
         */
        HTML("<br />"),
        /**
         * PLAIN_TEXT
         */
        PLAIN_TEXT("\n");
        private final String separator;

        private Format(String separator) {
            this.separator = separator;
        }

        private String formatToString(final Throwable t) {

            final StringBuilder sb = new StringBuilder();

            try (final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            final PrintStream ps = new PrintStream(buffer);) {

                t.printStackTrace(ps);
                sb.append(buffer.toString())
                .append(separator);

                for (Throwable cause = t.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(ps);
                    sb.append(buffer.toString());
                    if (cause.getCause() != null) {
                        sb.append(separator);
                    }
                }
            } catch (IOException ex) {
                sb.append("Não foi possível obter a stack trace [ ")
                .append(ex.getMessage())
                .append(" ]");
            }
            return sb.toString();
        }

        private Format get() {
            return this;
        }
    }

    /**
     * Cant be instantiate
     */
    private StackTraceFormatter() {
    }

    /**
     * Transforma toda a cadeia de StackTraces da Exceção em String separando as stacks de acordo com o formato passado.
     *
     * @param t Throwable
     * @param format pode ser qualquer um dos formatos da classe {@link StackTraceFormatter.Format}
     * @return <code> String </code> StackTrace Formata em String.
     *
     */
    public static String formatToString(final Throwable t, Format format) {
        return format.get().formatToString(t);
    }

    /**
     * Transforma toda a cadeia de StackTraces da Exceção em String separando as stacks no formato default.
     *
     * @param t Throwable
     * @return <code> String </code> StackTrace Formata em String.
     *
     */
    public static String formatToString(final Throwable t) {
        return Format.PLAIN_TEXT.formatToString(t);
    }
}
