public class TimedCharSequence  implements CharSequence {
    public static class TimeoutException extends RuntimeException {
        private static final String message = "Operations with timed char sequence took too long";

        public TimeoutException() {
            super(message);
        }

        public TimeoutException(Throwable err) {
            super(message, err);
        }
    }

    private final CharSequence inner;
    private final long deadline;


    public TimedCharSequence(CharSequence inner, long timeoutMs) {
        super();
        this.inner = inner;
        this.deadline = System.currentTimeMillis() + timeoutMs;
    }

    @Override
    public int length() {
        return inner.length();
    }

    @Override
    public char charAt(int i) {
        if (System.currentTimeMillis() > this.deadline) {
            throw new TimeoutException();
        }
        return inner.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return new TimedCharSequence(inner.subSequence(i, i1), this.deadline - System.currentTimeMillis());
    }
}
