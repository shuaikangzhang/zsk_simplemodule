package cn.zsk.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Administrator on 2018/2/7.
 */
public class CommonUtils {


    public static boolean checkBankCard(String bankCard) {
        return true;  // 工行卡号校验有问题，去掉此校验
        /*
        if(bankCard.length() < 15 || bankCard.length() > 19) {
            return false;
        }
        char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
        if(bit == 'N'){
            return false;
        }
        return bankCard.charAt(bankCard.length() - 1) == bit;
        */
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * @param nonCheckCodeBankCard
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeBankCard){
        if(nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
                || !nonCheckCodeBankCard.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeBankCard.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }

    public static boolean isMobile(String str) throws PatternSyntaxException {
        String regExp = "^1[34578]\\d{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public static boolean isIDCard(String str) throws PatternSyntaxException {
        String regExp = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public static void main(String [] args) {
        char ret = getBankCardCheckCode("6222080200024327184");
        System.out.print(ret);
    }


}
