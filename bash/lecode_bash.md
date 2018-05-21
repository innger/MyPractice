#leetcode shell练习
基本使用AWK，正则表达式，sort 排序，[在线地址](https://leetcode.com/problemset/shell/)

##[*192. Word Frequency*](https://leetcode.com/problems/word-frequency/)
>Write a bash script to calculate the frequency of each word in a text file words.txt
>sorted by descending frequency

```
awk '
{
    for(i=1;i<=NF;i++) {
        if(res[$i]>0){ 
            res[$i]=res[$i]+1
        }else{ 
            res[$i]=1
        }
    }
} 
END 
{
    for(k in res) 
        print k" "res[k]
}' words.txt | sort -nk 2 -r

cat words.txt | tr '[:space:]' "\n" | sed '/^$/d' | tr '[:upper:]' '[:lower:]'|sort|uniq -c|sort -nr | awk '{ print $2,$1}'
```

##[*193. Valid Phone Numbers*](https://leetcode.com/problems/valid-phone-numbers/)

```
awk '/^[0-9]{3}-[0-9]{3}-[0-9]{4}$/ || /^\([0-9]{3}\) [0-9]{3}-[0-9]{4}$/ {print}' file.txt

grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
```

##[*194. Transpose File*](https://leetcode.com/problems/transpose-file/)
> 将文件由列转换成行

```
awk '{for(j=1;j<=NF;j++){res[FNR,j] = $j;}} END {for(m=1;m<=NF;m++){for(n=1;n<=NR;n++){printf("%s",res[n,m]);if(n<NR){printf(" ")}} print ""}}' file.txt


awk '
{
    for (i = 1; i <= NF; i++) {
        if (NR == 1){
            s[i]=$i;
        }else{
            s[i] = s[i] " " $i;
        }
    }
}
END {
    for (i = 1; s[i] != ""; i++) {
        print s[i];
    }
}' file.txt
```

##[*195 Tenth Line*](https://leetcode.com/problems/tenth-line/)
>  How would you print just the 10th line of a file

```
awk 'NR==10 {print $0}' file.txt

sed -n '10p' file.txt
```


