package models;

public class Entry<T> implements Comparable<T> {

	private String spanishWord;
	private String englishWord;

	/**
	 * 
	 * @param spanishWord
	 * @param englishWord
	 * 
	 *            these are the standard getters and setters
	 * 
	 * 
	 */
	public Entry(String spanishWord, String englishWord) {
		this.spanishWord = spanishWord;
		this.englishWord = englishWord;
	}

	public void setSpanishWord(String spanishWord) {
		this.spanishWord = spanishWord;
	}

	public String getSpanishWord() {
		return spanishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getEnglishWord() {
		return englishWord;
	}

	/**
	 * returns the value obtained after comparing "this" object to another
	 * object (-1 || 0 || 1)
	 */
	@Override
	public int compareTo(Object other) {
		try {
			return this.getSpanishWord().compareTo(
					((Entry<?>) other).getSpanishWord());
		} catch (ClassCastException e) {
			return -2;
		}
	}
}
