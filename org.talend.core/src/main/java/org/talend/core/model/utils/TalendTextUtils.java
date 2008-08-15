// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.graphics.RGB;
import org.talend.core.CorePlugin;
import org.talend.core.database.EDatabaseTypeName;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.language.LanguageManager;
import org.talend.core.model.metadata.QueryUtil;
import org.talend.core.prefs.ITalendCorePrefConstants;

/**
 * DOC nrousseau class global comment. Detailled comment <br/>
 * 
 * $Id: talend-code-templates.xml 1 2006-09-29 17:06:40 +0000 (ven., 29 sept.
 * 2006) nrousseau $
 * 
 */
public class TalendTextUtils {

	public static final String SQL_BUILDER_TITLE_COMP_PREFIX = "SQL Builder [Component Mode] - Job:";

	public static final String SQL_BUILDER_TITLE_COMP_NAME = " - Component:";

	public static final String SQL_BUILDER_TITLE_REP = "SQL Builder [Repository Mode]";

	public static final String SQL_BUILDER_TITLE_COMP_MODPREFIX = "SQL Builder - Component Mode - Job:";

	public static final String SINGLE_QUOTE = "'"; //$NON-NLS-1$

	public static final String ANTI_QUOTE = "`";

	public static final String QUOTATION_MARK = "\""; //$NON-NLS-1$

	public static final String LBRACKET = "[";

	public static final String RBRACKET = "]";

	private static final int LINE_MAX_NUM = 100;

	private static final String JAVA_DECLARE_STRING = "\"";

	private static final String PERL_DECLARE_STRING = "'";

	private static final String JAVA_CONNECT_STRING = "+";

	private static final String PERL_CONNECT_STRING = ".";

	private static final String PASS_COVER = "*";

	/*
	 * ((?<!\\)".*?(?<!\\)") or ((?<!\\)'.?(?<!\\)')
	 */
	private static final String QUOTE_PATTERN = "((?<!\\\\)" + getQuoteChar()
			+ ".*?(?<!\\\\)" + getQuoteChar() + ")";

	public static String addQuotes(String text) {
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			return addQuotes(text, QUOTATION_MARK);
		default: // PERL
			return addQuotes(text, SINGLE_QUOTE);
		}
	}

	public static String declareString(String input) {
		if (input == null) {
			return null;
		}
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			return JAVA_DECLARE_STRING + input + JAVA_DECLARE_STRING;
		default: // PERL
			return PERL_DECLARE_STRING + input + PERL_DECLARE_STRING;
		}

	}

	public static String addQuotes(String text, String quoteStyle) {
		String newString;

		if (quoteStyle.equals(SINGLE_QUOTE)) {
			newString = SINGLE_QUOTE + checkStringQuotes(text) + SINGLE_QUOTE;
		} else if (quoteStyle.equals(ANTI_QUOTE)) {
			newString = ANTI_QUOTE + checkStringQuotationMarks(text)
					+ ANTI_QUOTE;
		} else if (quoteStyle.equals(LBRACKET) || quoteStyle.equals(RBRACKET)) {
			newString = LBRACKET + checkStringQuotationMarks(text) + RBRACKET;
		} else {
			newString = QUOTATION_MARK + checkStringQuotationMarks(text)
					+ QUOTATION_MARK;
		}
		return newString;
	}

	public static String addSQLQuotes(String text) {
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			return addSQLQuotes(text, QUOTATION_MARK);
		default: // PERL
			return addSQLQuotes(text, SINGLE_QUOTE);
		}
	}

	private static String addSQLQuotes(String text, String quoteStyle) {

		String newString;

		String tempText = text;

		tempText = tempText.replaceAll("\r", " ");
		tempText = tempText.replaceAll("\n", " ");
		tempText = tempText.trim();

		if (quoteStyle.equals(SINGLE_QUOTE)) {
			if (tempText.startsWith(SINGLE_QUOTE)
					&& tempText.endsWith(SINGLE_QUOTE)) {
				newString = text;
			} else {
				newString = SINGLE_QUOTE + checkStringQuotes(text)
						+ SINGLE_QUOTE;
			}
		} else if (quoteStyle.equals(ANTI_QUOTE)) {
			newString = ANTI_QUOTE + checkStringQuotationMarks(text)
					+ ANTI_QUOTE;
		} else if (quoteStyle.equals(LBRACKET) || quoteStyle.equals(RBRACKET)) {
			newString = LBRACKET + checkStringQuotationMarks(text) + RBRACKET;
		} else if (QueryUtil.isContextQuery) {
			newString = text;
			QueryUtil.isContextQuery = false;
		} else {
			if (tempText.startsWith(QUOTATION_MARK)
					&& tempText.endsWith(QUOTATION_MARK)) {
				newString = text;
			} else {
				newString = QUOTATION_MARK + checkStringQuotationMarks(text)
						+ QUOTATION_MARK;
			}
		}
		// newString = newString.replaceAll("\r", " ");
		// newString = newString.replaceAll("\n", " ");
		return widenSQLRestrict(newString, quoteStyle);
	}

	/**
	 * DOC qiang.zhang Comment method "widenRestrict".
	 * 
	 * @param newString
	 * @param quoteStyle
	 * @return
	 */
	private static String widenSQLRestrict(String newString, String quoteStyle) {
		String after = "";
		final String[] split = newString.split("\n");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			if (i == 0) {
				after += getAfterString(quoteStyle, string);
			} else {
				after += getAfterString(quoteStyle, "\n" + string);
			}
		}
		return after;
	}

	/**
	 * DOC qiang.zhang Comment method "getAfterString".
	 * 
	 * @param quoteStyle
	 * @param string
	 * @return
	 */
	private static String getAfterString(String quoteStyle, String string) {
		String after = "";
		if (string.length() > LINE_MAX_NUM) {
			String substring = string.substring(0, LINE_MAX_NUM);
			substring = substring.substring(0, getLastWord(string, substring,
					quoteStyle));
			after += substring + "\n";
			after += getAfterString(quoteStyle, string.substring(substring
					.length()));
		} else {
			after += string;
		}
		return after;
	}

	/**
	 * DOC qiang.zhang Comment method "getLastWord".
	 * 
	 * @param substring
	 * @param quoteStyle
	 * @return
	 */
	private static int getLastWord(String fullString, String substring,
			String quoteStyle) {
		if (substring.contains(",")) {
			int lastIndexOf3 = substring.lastIndexOf(",");
			if ((lastIndexOf3 + 1) < fullString.length()) {
				lastIndexOf3++;
			}
			return lastIndexOf3;
		} else if (substring.contains(" ")) {
			int lastIndexOf3 = substring.lastIndexOf(" ");
			if ((lastIndexOf3 + 1) < fullString.length()) {
				lastIndexOf3++;
			}
			return lastIndexOf3;
		} else {
			return substring.length();

		}
	}

	private static String checkStringQuotes(String str) {
		if (str == null) {
			return ""; //$NON-NLS-1$
		}
		return str.replace("'", "\\'"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private static String checkStringQuotationMarks(String str) {
		if (str == null) {
			return ""; //$NON-NLS-1$
		}
		return str.replace("\"", "\\\""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String addQuotesWithSpaceField(String fieldName, String dbType) {
		if (fieldName == null) {
			fieldName = "";
		}
		if (fieldName.startsWith("\"") && fieldName.endsWith("\"")) {
			return fieldName;
		}
		boolean b = true;
		for (int i = 0; i < fieldName.length(); i++) {
			char c = fieldName.charAt(i);
			b = b && c >= '0' && c <= '9';
		}
		EDatabaseTypeName name = EDatabaseTypeName.getTypeFromDbType(dbType);
		boolean isCheck = !CorePlugin.getDefault().getPreferenceStore()
				.getBoolean(ITalendCorePrefConstants.SQL_ADD_QUOTE);
		if (!b) {
			if (isCheck && !name.equals(EDatabaseTypeName.PSQL)
					&& !name.equals(EDatabaseTypeName.PLUSPSQL)) {
				return fieldName;
			}
		}
		String newFieldName = fieldName;
		String quote = getQuoteByDBType(name);
		if (!newFieldName.contains(quote)) {
			newFieldName = addQuotes(newFieldName, quote);
		}
		return newFieldName;
	}

	public static String addQuotesWithSpaceFieldForSQLString(String fieldName,
			String dbType, boolean simple) {
		if (fieldName.startsWith("\"") && fieldName.endsWith("\"")) {
			return fieldName;
		}
		boolean b = true;
		for (int i = 0; i < fieldName.length(); i++) {
			char c = fieldName.charAt(i);
			b = b && c >= '0' && c <= '9';
		}
		EDatabaseTypeName name = EDatabaseTypeName.getTypeFromDbType(dbType);
		boolean isCheck = !CorePlugin.getDefault().getPreferenceStore()
				.getBoolean(ITalendCorePrefConstants.SQL_ADD_QUOTE);
		if (!b) {
			if (isCheck && !name.equals(EDatabaseTypeName.PSQL)) {
				return fieldName;
			}
		}
		String newFieldName = fieldName;
		String quote = getQuoteByDBType(name);
		if (!newFieldName.contains(quote)) {
			newFieldName = addQuotesForSQLString(newFieldName, quote, simple);
		}
		return newFieldName;
	}

	public static String addQuotesWithSpaceFieldForSQLStringForce(
			String fieldName, String dbType, boolean simple) {

		boolean b = true;
		for (int i = 0; i < fieldName.length(); i++) {
			char c = fieldName.charAt(i);
			b = b && c >= '0' && c <= '9';
		}
		EDatabaseTypeName name = EDatabaseTypeName.getTypeFromDbType(dbType);
		boolean isCheck = !CorePlugin.getDefault().getPreferenceStore()
				.getBoolean(ITalendCorePrefConstants.SQL_ADD_QUOTE);
		if (!b) {
			if (isCheck && !name.equals(EDatabaseTypeName.PSQL)) {
				return fieldName;
			}
		}
		String newFieldName = fieldName;
		String quote = getQuoteByDBType(name);
		newFieldName = addQuotesForSQLString(newFieldName, quote, simple);
		return newFieldName;
	}

	/**
	 * 
	 * ggu Comment method "addQuotesForSQLString".
	 * 
	 * if simple is true, the text should not be the context or variables.
	 */
	private static String addQuotesForSQLString(String text, String quoteStyle,
			boolean simple) {

		String con = getStringConnect();
		String newString;
		if (simple) {
			String declare = getStringDeclare();
			text = removeQuotes(text, declare);
		}

		if (quoteStyle.equals(SINGLE_QUOTE)) {
			if (simple) {
				newString = declareString(SINGLE_QUOTE + text + SINGLE_QUOTE);
			} else {
				newString = declareString(SINGLE_QUOTE) + con + text + con
						+ declareString(SINGLE_QUOTE);
			}
		} else if (quoteStyle.equals(ANTI_QUOTE)) {
			if (simple) {
				newString = declareString(ANTI_QUOTE + text + ANTI_QUOTE);
			} else {
				newString = declareString(ANTI_QUOTE) + con + text + con
						+ declareString(ANTI_QUOTE);
			}
		} else if (quoteStyle.equals(LBRACKET) || quoteStyle.equals(RBRACKET)) {
			if (simple) {
				newString = declareString(LBRACKET + text + RBRACKET);
			} else {
				newString = declareString(LBRACKET) + con + text + con
						+ declareString(RBRACKET);
			}
		} else {
			/*
			 * quote is specific
			 */
			if (simple) {
				newString = declareString("\\" + QUOTATION_MARK + text + "\\"
						+ QUOTATION_MARK);
			} else {
				newString = declareString("\\" + QUOTATION_MARK) + con + text
						+ con + declareString("\\" + QUOTATION_MARK);
			}
		}
		return newString;
	}

	private static boolean isLeft = true;

	private static String getQuoteByDBType(EDatabaseTypeName name) {

		switch (name) {
		case GODBC:
			return QUOTATION_MARK;
		case IBMDB2:
			return QUOTATION_MARK;
		case INGRES:
			return QUOTATION_MARK;
		case MSODBC:
			return QUOTATION_MARK;
		case MSSQL:
			return QUOTATION_MARK;
		case MYSQL:
			return ANTI_QUOTE;
		case ORACLEFORSID:
			return QUOTATION_MARK;
		case ORACLESN:
			return QUOTATION_MARK;
		case PSQL:
			return QUOTATION_MARK;
		case SYBASEASE:
			return QUOTATION_MARK;
		case SYBASEIQ:
			return QUOTATION_MARK;
		case INTERBASE:
			return QUOTATION_MARK;
		case SQLITE:
			return QUOTATION_MARK;
		case FIREBIRD:
			return QUOTATION_MARK;
		case INFORMIX:
			return QUOTATION_MARK;
		case ACCESS:
			return getBracket();
		case TERADATA:
			return QUOTATION_MARK;
			// case JAVADB_DERBYCLIENT:
			// return QUOTATION_MARK;
			// case JAVADB_JCCJDBC:
			// return QUOTATION_MARK;
			// case JAVADB_EMBEDED:
			// return QUOTATION_MARK;
		default:
			return QUOTATION_MARK;
		}
	}

	/**
	 * qzhang Comment method "getBracket".
	 * 
	 * @return
	 */
	private static String getBracket() {
		if (isLeft) {
			isLeft = false;
			return LBRACKET;
		} else {
			isLeft = true;
			return RBRACKET;
		}
	}

	public static String removeQuotesForField(String text, String dbType) {
		String newText;
		isLeft = true;
		EDatabaseTypeName name = EDatabaseTypeName.getTypeFromDbType(dbType);
		final String quoteByDBType = getQuoteByDBType(name);
		if (quoteByDBType.equals(LBRACKET)) {
			if (text.length() > 2) {
				newText = text.substring(1, text.length() - 1);
				if (text.contains(RBRACKET)) {
					newText = newText.replaceAll(RBRACKET, "");
				} else {
					newText = text;
				}
			} else {
				newText = text;
			}

		} else {
			newText = text.replaceAll(quoteByDBType, "");
		}
		return newText;
	}

	/**
	 * qzhang Comment method "getQuoteByDBType".
	 * 
	 * @param dbType
	 * @param b
	 * @return
	 */
	public static String getQuoteByDBType(String dbType, boolean b) {
		isLeft = b;
		EDatabaseTypeName name = EDatabaseTypeName.getTypeFromDbType(dbType);
		return getQuoteByDBType(name);
	}

	public static RGB stringToRGB(String string) {
		RGB rgb;
		int r = 0;
		int g = 0;
		int b = 0;
		StringTokenizer token = new StringTokenizer(string, ";");
		if (token.hasMoreTokens()) {
			r = new Integer(token.nextToken());
		}
		if (token.hasMoreTokens()) {
			g = new Integer(token.nextToken());
		}
		if (token.hasMoreTokens()) {
			b = new Integer(token.nextToken());
		}
		rgb = new RGB(r, g, b);
		return rgb;
	}

	public static String removeQuotes(String text) {
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			return removeQuotes(text, QUOTATION_MARK);
		default: // PERL
			return removeQuotes(text, SINGLE_QUOTE);
		}
	}

	public static String removeQuotesIfExist(String text) {
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			if (text.startsWith(QUOTATION_MARK))
				return removeQuotes(text, QUOTATION_MARK);
			else
				return text;
		default: // PERL
			if (text.startsWith(SINGLE_QUOTE))
				return removeQuotes(text, SINGLE_QUOTE);
			else
				return text;
		}
	}

	/**
	 * qzhang Comment method "removeQuotes".
	 * 
	 * @param text
	 * @param quotation_mark2
	 * @return
	 */
	public static String removeQuotes(String text, String quotation) {
		if (text.length() > 1) {
			String substring = text.substring(0, 1);
			if (quotation.equals(substring)) {
				text = text.substring(1, text.length());
			}
			substring = text.substring(text.length() - 1, text.length());
			if (quotation.equals(substring)) {
				text = text.substring(0, text.length() - 1);
			}
		}
		return text;
	}

	private static boolean isPerlProject() {
		ECodeLanguage language = LanguageManager.getCurrentLanguage();

		switch (language) {
		case JAVA:
			return false;
		default: // PERL
			return true;
		}
	}

	public static String getStringConnect() {
		return isPerlProject() ? PERL_CONNECT_STRING : JAVA_CONNECT_STRING;
	}

	public static String getStringDeclare() {
		return isPerlProject() ? PERL_DECLARE_STRING : JAVA_DECLARE_STRING;
	}

	public static String trimParameter(String value) {
		// int length = value.length();
		String result = removeQuotes(value);
		// if (length > 1 && ((value.startsWith("\"") &&
		// value.endsWith("\"")))||(value.startsWith("\'") &&
		// value.endsWith("\'"))) {
		// result = value.substring(1, length - 1);
		// }
		if (result.contains("\\")) {
			result = result.replaceAll("\\\\n", "\n");
			result = result.replaceAll("\\\\b", "\b");
			result = result.replaceAll("\\\\f", "\f");
			result = result.replaceAll("\\\\r", "\r");
			result = result.replaceAll("\\\\t", "\t");
			result = result.replaceAll("\\\\\"", "\"");
			result = result.replaceAll("\\\\\\\\", "\\\\");
		}

		return result;
	}

	public static String getQuoteChar() {
		return isPerlProject() ? SINGLE_QUOTE : QUOTATION_MARK;
	}

	/**
	 * 
	 * ggu Comment method "filterQuote".
	 * 
	 * used for the string parsing, will ignore the char \" or \'.
	 */
	public static String filterQuote(final String str) {
		String newStr = replaceNewLine(str);

		Pattern regex = Pattern.compile(QUOTE_PATTERN, Pattern.CANON_EQ
				| Pattern.MULTILINE);
		Matcher regexMatcher = regex.matcher(newStr);
		String nonQuoteStr = newStr;
		if (regexMatcher.find()) {
			String quoteStr = regexMatcher.group(1);
			int index = newStr.indexOf(quoteStr);
			nonQuoteStr = newStr.substring(0, index);
			nonQuoteStr += newStr.substring(index + quoteStr.length());
			return filterQuote(nonQuoteStr);

		}
		return nonQuoteStr;
	}

	/**
	 * 
	 * DOC YeXiaowei Comment method "spellStringByQuote".
	 * 
	 * @param newStr
	 * @return
	 */
	public static List<KeyString> spellStringByQuote(final String newStr) {

		if (newStr == null || newStr.equals("")) {
			return null;
		}

		Pattern regex = Pattern.compile(QUOTE_PATTERN, Pattern.CANON_EQ
				| Pattern.MULTILINE);
		List<KeyString> res = new ArrayList<KeyString>();
		Matcher regexMatcher = regex.matcher(newStr);
		int nextBegin = 0;
		while (regexMatcher.find()) {
			int start = regexMatcher.start();
			int end = regexMatcher.end();
			if (nextBegin < start) {
				String firstPart = newStr.substring(nextBegin, start);
				res.add(new KeyString(firstPart, false));
			}
			String matchPart = newStr.substring(start, end);
			res.add(new KeyString(matchPart, true));
			nextBegin = end;
		}
		if (nextBegin < newStr.length()) {
			res.add(new KeyString(newStr.substring(nextBegin), false));
		}
		return res;
	}

	private static String replaceNewLine(final String str) {
		if (str == null) {
			return "";
		}
		String newStr = str;

		newStr = newStr.replaceAll("\r", " ");
		newStr = newStr.replaceAll("\n", " ");
		newStr = newStr.trim();

		return newStr;
	}

	/**
	 * 
	 * ggu Comment method "isCommonString".
	 * 
	 * if there are no any quotes , variables and expression(connected string)
	 * in string, will return true.
	 * 
	 */
	public static boolean isCommonString(final String str) {
		String newStr = replaceNewLine(str);

		Pattern regex = Pattern.compile(QUOTE_PATTERN, Pattern.CANON_EQ
				| Pattern.MULTILINE);
		Matcher regexMatcher = regex.matcher(newStr);
		if (regexMatcher.find()) { // has quote
			String non = filterQuote(newStr);
			if (!"".equals(non.trim())) { // has variables or is expression
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * DOC YeXiaowei Comment method "hidePassword".
	 * 
	 * @param password
	 * @return
	 */
	public static String hidePassword(final String password) {

		if (password == null) {
			return "**"; // Means two quote
		}

		int length = password.length() + 2;

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append(PASS_COVER);
		}

		return builder.toString();

	}

	/**
	 * 
	 * DOC YeXiaowei Comment method "filterOracleComponentName".
	 * 
	 * @param component
	 * @return
	 */
	public static String filterOracleComponentName(final String component) {
		if (component.startsWith("tOracleOutput")) {
			return "tOracleOutput";
		}
		if (component.startsWith("tOracleInput")) {
			return "tOracleInput";
		}

		return component;
	}

	/**
	 * 
	 * DOC YeXiaowei KeyString class global comment. Detailled comment <br/>
	 * 
	 */
	public static final class KeyString {

		private String string = null;

		private boolean key = false;

		public KeyString(final String string, final boolean key) {
			this.string = string;
			this.key = key;
		}

		public boolean isKey() {
			return this.key;
		}

		public String getString() {
			return this.string;
		}

		@Override
		public String toString() {
			return string + " ---> " + key;
		}
	}
}
