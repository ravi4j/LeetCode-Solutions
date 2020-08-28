/*
 * Copyright (c) Transplace, Inc, 2012. All rights reserved.
 * Unauthorized copying or usage of this file, via any medium is strictly prohibited.
 * Proprietary and confidential. Illegal distribution of files prohibited via any manner.
 */

package challenge.june2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P019_Longest_Duplicate_Substring {
	public static void main(String[] args) {
		P019_Longest_Duplicate_Substring solution = new P019_Longest_Duplicate_Substring();
		String S = "aaaaa";
		String result = solution.longestDupSubstring(S);
		System.out.println(result);

		S = "banana";
		result = solution.longestDupSubstring(S);
		System.out.println(result);

		S = "unuoqslvgaekunapeaapsxbodakcrapmmfuxoowlysenyiygzhawbfbuxlswtxzzhlspfgzckzuoxizijrluvndcpnknsvrnfulksqqxdznfjgjlocozuolroealyhhwrzcsuzgcsekkqmwlnylsscpmynjchwvpwebwkraudfqboeqmxhghekcstrcozldbwyniwqmyrbkzwvknulehzxwckwohlmjvlqyexvzzlptbnnbctywyezcssubmiukcsixmnapgttmlfwtwnmxqgsobqsnxucwrszxcuprnlxjteytwqzridgtgkkbsekeytuxslavhebbpjewdwlhchtzwohqkojiqneahxacutymteoyloottnsmmrphngclortfvudoeckxkjqatxqmvboumxmdrxoxpyprkwvfpviqkbhsjdeosxdbzzfsomrxojkokofrrdoavhjufyayisibcgngqprircpcjyvynhzmrtyynfgfgeomscywbcvmlhcmyesuxwurmpdxhddyfnumgkvphmtqzrbsbjeliyrqfswrchkurvqtsmzchjfvotdmueabpllagtfvefssmgevrzydftuvxqdbdrpysifoxgvlkljhkiksoxfndxayrsaxeoefmimnqfeerggwxsbyarfvfwvrmtwjainqposafhwysxaaegzeewhyrsfnduqihpwipeewnubscqpvjekikyiwmpwynydbnvylqydgiwsenvulkknlbuqpwhxqclrnuvdwqpxkksyewsklffwtggbmxnttvnjbiqjdoezffmmighfdcirjakacncwckjqwqsjxsbsxbaeaagmnybxpwvucyskfkydlkxdlfmodygcxzimmhdgmwwqxrflldkwvyqlfwasxxoetlgtopmqnfkfvkshkrikfcvdrguxciupphxyssowakrnsiutntlliedxnqkldzfkqefgvyaargpqbknlmlbejkuupolrhapowrgciyteeeulpldvlqkklwsxtvcmxjozbfqgmslutnkspfoaeylxufmuropnafrjveufqymddcrzvbdkhghzvbjzxyuibkemslbsluzwnduiutluergimcjsziusnqhyazuhskekblpoexmurndswlwxwieujdyilfntaaphwvnauvwmihlfphfpxzkwinxitiqxamjqxtdxswgxfmsfuqwtqqnzracsoerlrntgyypdroiuqtiawxeogqcrxxbjmgkqrlrbgeglkamqfvgaiipuxcvllcujnnlfzidrvzowaupaucbxzwzhueqqdphpmsdszdtcycrmiwyhslbvknlxhfgpcbotvarakaymjgfydzfmnxwausfhdxulmxhvzgbswfdwrtitwyibwfnpsekmymsglzpiyrhnuaatmqkjqhcwycnaxjbxqgprgoesjnupyfhbyounmbwgjfplslyudxyaxuspyxjcuorzxcryiuwlgprpurjdxozsalkbjcjatnxstbxinrokiufjldyuyngkiobomuemplhziwaapevhrluxohodizmmqznpbggcaqfgobgpvytmbpdmrrcbzbgrppmlmigghuzrdfhwhksgmmnjnbglrrckwbdstsjdjxaeopxawedvszchktinhceceauookzcwbdkbglzkedrjuqhrnaxluttcjbbdmqimlgppvuvmjqipkcjvyzhingwymthqrpguhvlcjqrstczkdvdrwwtwdrakmbxzjfsszpziurglmpsyllgxtbewoftnhvzmtygsvbnwhltwqszqdopzxbwyrdyrpffnilfdxtlofyicjshyrpncsqndubqkgkgrtbybulwegugcvfqhpfnvvccocolfpiyojgoranoyegkpitmfkmdkyihdqscwykyhgkyljypjobeijjvdpjglbkefxtsmyyytluqpvdcsgrtvsamzupdjyzqtcvpoquialxzaeerxtqkitsapniklylrztgclbxyzzrkanhucwdccdvafyirulajxbmeyaoqtqpprkohdddzdxtiwwctcevneriqahvrgyqvyrwfcvvqbhxmiajqkwhztepimveqisonqccfgwnhpkkqsqlmqqszwjxcpmyzldhjmriayuxpfosdtmhvtncuboiggyroxgwlbybievmdwaverpetzrmeogojuyipkwsibihuhzxjnwugjpwonfsbwaxfcqveyipwkhkzsfarvxrdlxvoiduextlcnnwuaiishdbfnxvfzkqfbqynfznbqijfkamnhlwcmkysbotlebtyfkoptfignbwxfldmbebmtyoggfvbyyygbibfhgfrdtwptwihjndlxmtdkntxtfjwstbmukwlwkzecogozerskubaxjqtliwpgyfwvkqqagmwmnfvuoujlelopdbfqyjnemaibfmgfhqzoptcolufrgafmwkzlxaudgvkhicwjdyomiqgoapvhyakslmhnznivjulyyqusxolkmfyskcfgshotfdjbtmflvtagraeazawnbtcquiivziijjporrsuytdkayjtnexvwtoswqmncbvwsxcaowrjmqdtyzqdjrqbmnaqqlkbdsrweeofeztqlgijzsriayrlknxcinibqqguxztuikzetcwipuchwukczxunuoqslvgaekunapeaapsxbodakcrapmmfuxoowlysenyiygzhawbfbuxlswtxzzhlspfgzckzuoxizijrluvndcpnknsvrnfulksqqxdznfjgjlocozuolroealyhhwrzcsuzgcsekkqmwlnylsscpmynjchwvpwebwkraudfqboeqmxhghekcstrcozldbwyniwqmyrbkzwvknulehzxwckwohlmjvlqyexvzzlptbnnbctywyezcssubmiukcsixmnapgttmlfwtwnmxqgsobqsnxucwrszxcuprnlxjteytwqzridgtgkkbsekeytuxslavhebbpjewdwlhchtzwohqkojiqneahxacutymteoyloottnsmmrphngclortfvudoeckxkjqatxqmvboumxmdrxoxpyprkwvfpviqkbhsjdeosxdbzzfsomrxojkokofrrdoavhjufyayisibcgngqprircpcjyvynhzmrtyynfgfgeomscywbcvmlhcmyesuxwurmpdxhddyfnumgkvphmtqzrbsbjeliyrqfswrchkurvqtsmzchjfvotdmueabpllagtfvefssmgevrzydftuvxqdbdrpysifoxgvlkljhkiksoxfndxayrsaxeoefmimnqfeerggwxsbyarfvfwvrmtwjainqposafhwysxaaegzeewhyrsfnduqihpwipeewnubscqpvjekikyiwmpwynydbnvylqydgiwsenvulkknlbuqpwhxqclrnuvdwqpxkksyewsklffwtggbmxnttvnjbiqjdoezffmmighfdcirjakacncwckjqwqsjxsbsxbaeaagmnybxpwvucyskfkydlkxdlfmodygcxzimmhdgmwwqxrflldkwvyqlfwasxxoetlgtopmqnfkfvkshkrikfcvdrguxciupphxyssowakrnsiutntlliedxnqkldzfkqefgvyaargpqbknlmlbejkuupolrhapowrgciyteeeulpldvlqkklwsxtvcmxjozbfqgmslutnkspfoaeylxufmuropnafrjveufqymddcrzvbdkhghzvbjzxyuibkemslbsluzwnduiutluergimcjsziusnqhyazuhskekblpoexmurndswlwxwieujdyilfntaaphwvnauvwmihlfphfpxzkwinxitiqxamjqxtdxswgxfmsfuqwtqqnzracsoerlrntgyypdroiuqtiawxeogqcrxxbjmgkqrlrbgeglkamqfvgaiipuxcvllcujnnlfzidrvzowaupaucbxzwzhueqqdphpmsdszdtcycrmiwyhslbvknlxhfgpcbotvarakaymjgfydzfmnxwausfhdxulmxhvzgbswfdwrtitwyibwfnpsekmymsglzpiyrhnuaatmqkjqhcwycnaxjbxqgprgoesjnupyfhbyounmbwgjfplslyudxyaxuspyxjcuorzxcryiuwlgprpurjdxozsalkbjcjatnxstbxinrokiufjldyuyngkiobomuemplhziwaapevhrluxohodizmmqznpbggcaqfgobgpvytmbpdmrrcbzbgrppmlmigghuzrdfhwhksgmmnjnbglrrckwbdstsjdjxaeopxawedvszchktinhceceauookzcwbdkbglzkedrjuqhrnaxluttcjbbdmqimlgppvuvmjqipkcjvyzhingwymthqrpguhvlcjqrstczkdvdrwwtwdrakmbxzjfsszpziurglmpsyllgxtbewoftnhvzmtygsvbnwhltwqszqdopzxbwyrdyrpffnilfdxtlofyicjshyrpncsqndubqkgkgrtbybulwegugcvfqhpfnvvccocolfpiyojgoranoyegkpitmfkmdkyihdqscwykyhgkyljypjobeijjvdpjglbkefxtsmyyytluqpvdcsgrtvsamzupdjyzqtcvpoquialxzaeerxtqkitsapniklylrztgclbxyzzrkanhucwdccdvafyirulajxbmeyaoqtqpprkohdddzdxtiwwctcevneriqahvrgyqvyrwfcvvqbhxmiajqkwhztepimveqisonqccfgwnhpkkqsqlmqqszwjxcpmyzldhjmriayuxpfosdtmhvtncuboiggyroxgwlbybievmdwaverpetzrmeogojuyipkwsibihuhzxjnwugjpwonfsbwaxfcqveyipwkhkzsfarvxrdlxvoiduextlcnnwuaiishdbfnxvfzkqfbqynfznbqijfkamnhlwcmkysbotlebtyfkoptfignbwxfldmbebmtyoggfvbyyygbibfhgfrdtwptwihjndlxmtdkntxtfjwstbmukwlwkzecogozerskubaxjqtliwpgyfwvkqqagmwmnfvuoujlelopdbfqyjnemaibfmgfhqzoptcolufrgafmwkzlxaudgvkhicwjdyomiqgoapvhyakslmhnznivjulyyqusxolkmfyskcfgshotfdjbtmflvtagraeazawnbtcquiivziijjporrsuytdkayjtnexvwtoswqmncbvwsxcaowrjmqdtyzqdjrqbmnaqqlkbdsrweeofeztqlgijzsriayrlknxcinibqqguxztuikzetcwipuchwukczx";
		result = solution.longestDupSubstring(S);
		System.out.println(result);

	}

	public String longestDupSubstring(String S) {
		int n = S.length();
		int left = 0;
		int right = n - 1;
		int base = 26;
		int[] power = new int[n];
		long mod = 1 << 63 - 1;
		power[0] = 1;
		for (int i = 1; i < n; i++) {
			power[i] = (int) ((power[i - 1] * base) % mod);
		}
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = S.charAt(i) - 'a';
		}
		String result = "";
		while (left <= right) {
			int mid = left + (right - left) / 2;
			String current = search(S, nums, power, base, mod, mid);
			if (result.length() < current.length()) {
				result = current;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	private String search(String S, int[] nums, int[] power, int base, long mod, int len) {
		if (len == 0) {
			return "";
		}
		Map<Long, List<Integer>> hash = new HashMap<>();
		long h = 0;
		for (int i = 0; i < len; i++) {
			h = ((h * base + nums[i]) % mod);
		}
		List<Integer> indexList = new ArrayList<>();
		indexList.add(0);
		hash.put(h, indexList);

		for (int i = len; i < nums.length; i++) {
			h = (((h - power[len - 1] * nums[i - len]) % mod) + mod) % mod;
			h = (h * base + nums[i]) % mod;
			if (!hash.containsKey(h)) {
				List<Integer> list = new ArrayList<>();
				list.add(i - len + 1);
				hash.put(h, list);
			} else {
				for (Integer index : hash.get(h)) {
					String str = S.substring(i - len + 1, i + 1);
					String matchStr = S.substring(index, index + len);
					if (matchStr.equals(str)) {
						return matchStr;
					}
				}
				hash.get(h).add(i - len + 1);
			}
		}
		return "";
	}

	/*public int search(int L, int a, long modulus, int n, int[] nums) {

		long h = 0;
		for (int i = 0; i < L; ++i)
			h = (h * a + nums[i]) % modulus;


		Set<Long> set = new HashSet();
		set.add(h);
		// const value to be used often : a**L % modulus
		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {
			// compute rolling hash in O(1) time
			h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			h = (h + nums[start + L - 1]) % modulus;
			if (set.contains(h))
				return start;
			set.add(h);
		}
		return -1;
	}

	public String longestDupSubstring(String S) {
		int n = S.length();
		// convert string to array of integers
		// to implement constant time slice
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
			nums[i] = (int) S.charAt(i) - (int) 'a';
		// base value for the rolling hash function
		int a = 26;
		// modulus value for the rolling hash function to avoid overflow
		long modulus = (long) Math.pow(2, 32);

		// binary search, L = repeating string length
		int left = 1, right = n;
		int L;
		while (left != right) {
			L = left + (right - left) / 2;
			if (search(L, a, modulus, n, nums) != -1)
				left = L + 1;
			else
				right = L;
		}

		int start = search(left - 1, a, modulus, n, nums);
		return start != -1 ? S.substring(start, start + left - 1) : "";
	} */
}
