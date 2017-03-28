package com.ryl.learn.lecode;

import java.util.*;

/**
 * medium problem
 * Created by renyulong on 16/2/3.
 */
public class MediumMain {
    
    public static void main(String[] args) {
        MediumMain main = new MediumMain();
        int[] arr = new int[]{1, 1, 1, 1, 3, 3};
        arr = new int[]{1, 1, 1, 1, 2, 2, 3};
        int len = main.removeDuplicates(arr);
        System.out.println(len + " " + Arrays.toString(arr));
        
        int ugly = main.nthUglyNumber(7);
        System.out.println(ugly);
        
        System.out.println(main.find132pattern(new int[]{8, 9, 10, 7, 9}));
        
        System.out.println(main.removeKdigits2("1432219", 3));
        System.out.println(main.removeKdigits2("10200", 1));
        System.out.println(main.removeKdigits("1111111", 3));
        System.out.println(main.removeKdigits("1234567890", 9));
        System.out.println(main.removeKdigits("10", 2));
//        String str = "99641436378815361153471302158193420182863684789411484994976484827114595334610042544056442370530816060833617030976813134098793056155103202008549344446519354408307307071055065112738442020228471569394796174150323080161225901964338837341524253243218509500254619223683091799365677720582389568156585225666197123093377871100002481402486219837255411382162499321193416524972275273471969155848742457476556433737281147710021781210134765321761285612276511917324552585569882156635094670362653567596144728653795007023230933817566104488637696450166087905100823699425798763598444326069357052842379918535855296915760054459317433521878778171811081076593166663090948029793113626852462712388116483774713426183911481230884393594249331828165503798269634244430773693033882708000249632850148799859322024693146577635543114657662418998860517525989192973250701631765598465053097616804817344343895016724561947860836117504915797011185132674255278236597746042138768473723059825948301565719437610732907662545499042953499866813741157301003371005200992314265077531029437948931255617153417148822355928318598517533241719641002712204874161001604269216566928220767474713135516717997491363360204764154264989004671363541097433484822118483642107547658581450616821769964767032521138851570822729134762460014265433227201724724004338494552397280090568164786109721571436206198382814849033856987338787473335772666933218810822482848994610491705665155516384799459418594559136827941106387689501641851101743298582575466303864906673788496628288920867422193950180810131396612913851112593807649152972068279299934113463669714575613645929365652921808836725682390026075559320995704880149764583379697505303474550029059828116836469203370428449330442281563135568935742669243344218603994417955703485059862132359688776290378210392955310785874528205203788559715493852405991380290274268143557970398441851157977520689440430265144029789788511042795879174567381358510694749512938934687979305099149575464220629804942550564164786808856897809863824121659548034395539735407069279457678613909222371848892294754933299091164656871086269084324529512544747434123547189729993758337622038098699448815701644934651292719067683227727438808955969543542319197883567369733867364250353136697865107182282929655918362211832327827571354787535611501731943856155003853732339819594939524719169561110698571676562329360803282215467534058504728127731515598941143637827010955579092451405821352126706550438315176049692316210490899702613078702535716735901806171522853021035597316703390478571485677998207922773938829371460838611214446417528913575284776737837046439695408523434414916342979688820197836458637694991540998291690345194205452439239827382953039810367712244590155940394387554911786652478111954297185544106384174592451680875083737874735810068767866214924634885513828808880161930987276602570872860752119813042414550396358433893592777541756673206882876746731707766966268096104320061937913505893028833592137540396064375155513979764728180927083060481127522118240026140625647313783901073938419240249929000962722034273952683635919540169732220854978101308126446671885186032295490845060116567165945677975672981321362161949418405852378788584602802612398876874288293756055559457538271197205867506313677160755990736347314715042607243878693780144368083800080967842966193539823770427967091132770230485036143223363387876244958899577538069175123004651952588711287008791159682042581943812962882375293348462523257081140457567348612069746943329842264291823570671268374580651696311114624358304235261945894627668267192756606441264485628097480920062857007640396910214970556623416565940789636657349735150043836194242061994234044262604284350296258397208287158735477739515615890093167555389262170576609082365199242352356197706754361085079177223144662701424848070607319078068303190442737202186364818021792860690571733432439513976759807778513151206801184300729685910765785586373831699595178352610150383283823456881293647763022411686252640648120690251120902631370825525354213297549430441989419362406888242180413640397005462289002837178086683143441254722528075315187910994986929463063282350677644105312484770818851268755183086729904524488901102287310169865855725358976453628171038414004415469635124255044890245890050115901243603489384920067923087045070616429510114587493955384903357111302068595548921504222171096098548413208088831560744996899783844118318185694142620796984004522106434428513215881883542758888862576036415421097762413907290417004936441609238204617100586876487061497586106631983740139555573272626681186969272113315348553052708453716313010811194726904231406455432865684477036960953564406390115786323388585604716504384778912812410729908949581143722120318954849846535676912868526526501078193502393524062471534154104899815734648650035608611113327222040864146091286020205304970098510045582130989981665393076480660907742469107193219475618455618115516353495211289597815564506193368287178714208989206470099207227171770619580227427772058576958549342547850566371060314330889132466260972915500785842700966615103949831075688522846389635990078358138687466663099265099431775674237640711466272609872329090894406587154198409486434056948991642623725868520261081714501891452704954562834244485695899485150794033902595303371632597184940525684558272222395813587950566598836575728711404672894869851301199508345442816914540274231773573695049117433232750564343477296571911336451338765122801905492189124021699698020217831160061375249740348841211772476455089061870953510480256335713228323198782026742817220321247980121667780800877801219532811542139900480803615083739957513418528009253849655053312995534574307148952727627870318872325094411860749809155407484065987101730385346571248798467212335910821152286411077915790397497756477613051365987943518909759211252763081626026136209474490841118337332773116122063152414208776801671614382203998310801791046109980464795153775904284579208046765170299376571712696359391195309011046580945099118345329164807866461624513459858969478261348365746242842254100449074846018162381649508771205692387943049083877156128753239386498305599949138477358461424273464036997642435352074743094695564535693378173888280633866732018710701060752702258884562187458492514181027419045608607139753797741693225900923436163273291784047946102859573341135995351940672974945745062320931107916232460722010886651827074516009065280667168017782964663521168472263155891094369134584611694802620433621767214124173962636180142978128638945692419270222518432363382128100260544917455244318162619360808797214154001396840051520865249909119773623276044783996235484958441702533661095335337458603732924068113476544273220040621287278168707393471504842692312354782265568742305367773635557008065688109790648713350572351799924638273829816187626279342407486758617884199669669286080608957640162096427744397522103026413782698158732581790000716751490076906346484023835702438474105176931779065689980130347837155056303467742499515965713045957954225592059807462917282749105358673064716135765849677591608061323905019687616579401117839719269327243007586938365568212311638431283680946079388989080798521721770825311237382299640977231722390040018733060008726711369177955792504805871660952275133036361448257222162174106121886956846208577175900217031085260775753651365765038925717954695019720235653672968689019573262654460436772900765775615489257834882352941349073672575670561593061387879337673233294306479935031268311515186416299622966578517978675818927585118344348361158710756313053131716293124192982037977789379782122120656399498488608931743952536041546453299501041577456229618221253519224906611827751220393777623642577532653929191439603183004880021982807536023221789599010502125687724004685177438516674638976736887749480118357141229355178588718777866510629202733751110559334924038607709059709853979249569510212755627954315025008066453716096825677236680969921750877126730256949811077056975031686370565845816981036167892330455103497165407984322792515265566483796338273488042877728447328933645773410093062365682687268013318931065552717013674172822704288279197461978805944285413220284999303849740540429893025407810120053701999064303195562726870079068213843151094378846458471168159763363401468459072474435300433314015701363633705309153196187013664717617975618648227816754951474354742056233896619815305871556180590934191775446450232435064334173434855333465262160341517250209548644211312373841441024747539900101488865742679168673356769004244781832745045012713439497231232255815861738982590755401780194874615548229070120796893835181030047378827641086164272219294123942746140207443292075817414598536256892540490923602419336928186124051416665048479530882042184097629985897052425322145715174649893481917612568426372077919256931921063600255204010662044398922537796993713110889134889921360833579323314386803074533058134342770923839546994120322442157750203621967931319597649960815556196358566683782572730174920215034531104191490057838260392829741446722127017532444082857280503217574522928285094747407153894570747792487061998260753833304433675066923630595212677695003060727653119915126939127827754432456052655283764591328484359469704894122366077507922825301623961196207923544095047285011474898262448957681893278273601046641810135121516552187096005252171171905022763076761687166299014789581539855448453229411352775826042558462563147630238335355859149814380543807473386539264830261256996173935860136236427622918234260408201158550118527706241993700526213016072648406003487895118011337828945314863348154387066988573131543747121745028364818130265528614742576976975564213718421245904443000581698214695522541683926528961160986876871840844632069685227319014872180179370554032205521013345746425253133686231659075343389374580200717637698542920298315739628019867736462368334051114029380922339886663078026309916370486909128253195100898377068612057592121356555290537815049586626181680384845905180029133497372417653664436161971980137048236053329456957495141918670077299206755740534997886723627476115663811233372206043170460623060506091246306386543951687123557178508806912199010111871";
//        System.out.println(str.length());
//        System.out.println(main.removeKdigits2(str, 1000));
        
        
        String intervalString = "[-100,-87],[-99,-44],[-98,-19],[-97,-33],[-96,-60],[-95,-17],[-94,-44],[-93,-9],[-92,-63],[-91,-76],[-90,-44],[-89,-18],[-88,10],[-87,-39],[-86,7],[-85,-76],[-84,-51],[-83,-48],[-82,-36],[-81,-63],[-80,-71],[-79,-4],[-78,-63],[-77,-14],[-76,-10],[-75,-36],[-74,31],[-73,11],[-72,-50],[-71,-30],[-70,33],[-69,-37],[-68,-50],[-67,6],[-66,-50],[-65,-26],[-64,21],[-63,-8],[-62,23],[-61,-34],[-60,13],[-59,19],[-58,41],[-57,-15],[-56,35],[-55,-4],[-54,-20],[-53,44],[-52,48],[-51,12],[-50,-43],[-49,10],[-48,-34],[-47,3],[-46,28],[-45,51],[-44,-14],[-43,59],[-42,-6],[-41,-32],[-40,-12],[-39,33],[-38,17],[-37,-7],[-36,-29],[-35,24],[-34,49],[-33,-19],[-32,2],[-31,8],[-30,74],[-29,58],[-28,13],[-27,-8],[-26,45],[-25,-5],[-24,45],[-23,19],[-22,9],[-21,54],[-20,1],[-19,81],[-18,17],[-17,-10],[-16,7],[-15,86],[-14,-3],[-13,-3],[-12,45],[-11,93],[-10,84],[-9,20],[-8,3],[-7,81],[-6,52],[-5,67],[-4,18],[-3,40],[-2,42],[-1,49],[0,7],[1,104],[2,79],[3,37],[4,47],[5,69],[6,89],[7,110],[8,108],[9,19],[10,25],[11,48],[12,63],[13,94],[14,55],[15,119],[16,64],[17,122],[18,92],[19,37],[20,86],[21,84],[22,122],[23,37],[24,125],[25,99],[26,45],[27,63],[28,40],[29,97],[30,78],[31,102],[32,120],[33,91],[34,107],[35,62],[36,137],[37,55],[38,115],[39,46],[40,136],[41,78],[42,86],[43,106],[44,66],[45,141],[46,92],[47,132],[48,89],[49,61],[50,128],[51,155],[52,153],[53,78],[54,114],[55,84],[56,151],[57,123],[58,69],[59,91],[60,89],[61,73],[62,81],[63,139],[64,108],[65,165],[66,92],[67,117],[68,140],[69,109],[70,102],[71,171],[72,141],[73,117],[74,124],[75,171],[76,132],[77,142],[78,107],[79,132],[80,171],[81,104],[82,160],[83,128],[84,137],[85,176],[86,188],[87,178],[88,117],[89,115],[90,140],[91,165],[92,133],[93,114],[94,125],[95,135],[96,144],[97,114],[98,183],[99,157]";
        intervalString = intervalString.replace("[", "");
        intervalString = intervalString.replace("]", "");
        String[] intervalArr = intervalString.split(",");
        int size = intervalArr.length / 2;
        Interval[] intervals = new Interval[size];
        int i = 0;
        while (i < intervalArr.length) {
            intervals[i / 2] = new Interval(Integer.valueOf(intervalArr[i]), Integer.valueOf(intervalArr[i + 1]));
            i += 2;
        }
        System.out.println(Arrays.toString(intervals));
        System.out.println(main.eraseOverlapIntervals(intervals));
    
        System.out.println(Arrays.toString(main.overlap(new int[] {1,10},new int[] {11,13} )));
        
        int[][] points = new int[][] {
                {10,16},{2,8},{1,6},{7,12}
        };
        System.out.println(main.findMinArrowShots(points));
    
        points = new int[][] {
                {1,2},{3,4},{5,6},{7,8}
        };
        System.out.println(main.findMinArrowShots(points));
    }
    
    /**
     * 452. Minimum Number of Arrows to Burst Balloons
     * <p>
     * 每个元素代表一个气球的x坐标区间(气球的直径),y高度不限,
     * 射箭的位置在x轴,射箭在某个位置上射出无限远
     * 求最少使用的箭数,将所有的气球击落
     * Input: [[10,16], [2,8], [1,6], [7,12]] Output: 2
     * 贪心典型应用,区间重叠问题
     *
     * @param points int[][]
     * @return int
     */
    public int findMinArrowShots(int[][] points) {
        //找出重叠最多的区域
        int len = points.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        //按照start排序
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        int arrow = 0;
        int[] point = points[0];
        int i = 1;
        while (i < len) {
            int[] next = points[i];
            while(true) {
                //尽量找出最多的重叠部分
                int[] over = overlap(point, next);
                if(over != null) {
                    point = over;
                    i++;
                    if(i >= len) {
                        break;
                    }
                    next = points[++i];
                } else {
                    next = null;
                    point = points[i];
                    break;
                }
            }
            i++;
            arrow++;
            if(i == len && next == null) {
                //next=null 最后一个判断
                arrow++;
            }
        }
        return arrow;
    }
    
    private int[] overlap(int[] p1, int[] p2) {
        int start = Math.min(p1[0], p2[0]);
        int end = Math.max(p1[1], p2[1]);
        int len = end - start;
        int len2 = (p1[1] - p1[0]) + (p2[1] - p2[0]);
        if (len > len2) {
            return null;
        }
        int[] res = new int[2];
        res[0] = Math.max(p1[0], p2[0]);
        res[1] = Math.min(p1[1], p2[1]);
        return res;
    }
    
    public int findMinArrowShots2(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int minArrows = 1;
        int arrowLimit = points[0][1];
        for(int i = 1 ; i < points.length; i++) {
            int[] baloon = points[i];
            if(baloon[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, baloon[1]);
            } else {
                minArrows++;
                arrowLimit = baloon[1];
            }
        }
        return minArrows;
    }
    
    
    
    /**
     * 435. Non-overlapping Intervals
     * <p>
     * 找出最少移除的interval,使得剩下的互相不重叠
     * 给出的Interval end > start
     * [1, 2] [2, 3] 相邻,不算重叠
     * Input: [ [1,2], [2,3], [3,4], [1,3] ] Output: 1
     * Input: [ [1,2], [1,2], [1,2] ] Output: 2
     * Input: [ [1,2], [2,3] ] Output: 0
     *
     * @param intervals Interval[]
     * @return int
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        //确定第一块区间
        int len = intervals.length;
        if (len == 0) return 0;
        //end排序
        Arrays.sort(intervals, (o1, o2) -> o1.end - o2.end);
        int num = 1;
        int end = intervals[0].end;
        for (int i = 1; i < len; i++) {
            Interval interval = intervals[i];
            //贪心,每次添加start 大于 最小end,更新end
            //局部最优解,无后效性,每次添加一个区间 num++
            if (interval.start >= end) {
                end = interval.end;
                num++;
            }
        }
        return len - num;
    }
    
    
    static class Interval {
        int start;
        int end;
        
        Interval() {
            start = 0;
            end = 0;
        }
        
        Interval(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public String toString() {
            return "{start=" + start +
                    ", end=" + end + "}";
        }
    }
    
    /**
     * 402. Remove K Digits
     * 从num中移除k位,使新num值最小
     * num中不包含leading zero
     * <p>
     * Input: num = "1432219", k = 3 Output: "1219"
     * Input: num = "10200", k = 1 Output: "200"
     * Input: num = "10", k = 2 Output: "0"
     * <p>
     * stack greedy
     *
     * @param num String 非负整数的字符串表示 len < 10002 && len >= k
     * @param k   int
     * @return String
     */
    public String removeKdigits(String num, int k) {
        //无后效性,每次移除一位,获取最小值
        if (num.length() <= k) return "0";
        Stack<Integer> stack = new Stack<>();//index
        int kk = 0;
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                char cur = arr[i];
                char stc = arr[stack.peek()];
                if (cur >= stc) {
                    stack.push(i);
                } else {
                    arr[stack.pop()] = 0;
                    kk++;
                    while (kk < k && !stack.isEmpty() && cur < arr[stack.peek()]) {
                        arr[stack.pop()] = 0;
                        kk++;
                    }
                    if (kk >= k) {
                        break;
                    }
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty() && kk < k) {
            arr[stack.pop()] = 0;
            kk++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch == 0 || ch == '0' && sb.length() == 0) {
                continue;
            }
            sb.append(ch);
        }
        return String.valueOf(sb.length() > 0 ? sb : "0");
    }
    
    public String removeKdigits2(String num, int k) {
        int len = num.length();
        int digits = len - k; //结果字符数
        char[] stk = new char[len];
        int top = 0;
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stk[top++] = c;
            //k==0 提前结束
            if (k == 0) {
                i++;
                System.arraycopy(num.toCharArray(), i, stk, top, len - i);
                break;
            }
        }
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits ? "0" : new String(stk, idx, digits - idx);
    }
    
    /**
     * 456. 132 Pattern
     * 132模式的子序列 ai, aj, ak such that i < j < k and ai < ak < aj.
     * 不要求连续 [凸型子序列]
     * <p>
     * Stack nums[i] s3 栈顶 三个元素比较
     *
     * @param nums int[] 数组长度不超过15,000
     * @return true/false
     */
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) return true;
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = stack.pop();
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }
    
    //普通解法 TimeLimited
    public boolean find132pattern2(int[] nums) {
        //time limited
        if (nums == null || nums.length < 3) {
            return false;
        }
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int target = nums[i];
            Integer max = null;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > target) {
                    if (max == null) {
                        max = nums[j];
                    } else if (max < nums[j]) {
                        max = nums[j];
                    } else if (max > nums[j]) {
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }
    
    /**
     * a1, a2, ..., an,  (i, ai) and (i, 0) and x-axis 组成的四边形,contains the most water
     * You may not slant the container.
     * two pointers 两头向中间收缩
     *
     * @param height int[]
     * @return int
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            int a = h * w;
            max = Math.max(max, a);
            
            if (i + 1 < j && Math.min(height[i + 1], height[j]) > h) {
                i++;
            } else if (j - 1 > i && Math.min(height[i], height[j - 1]) > h) {
                j--;
            } else {
                //从小的边推进
                if (height[j] < height[i]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return max;
    }
    
    /**
     * 优化方案,内部嵌套while循环,取消无用的面积计算
     *
     * @param height int[]
     * @return maxArea
     */
    public int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                int k = i;
                while (k < j && height[k] <= height[i]) {
                    k++;
                }
                i = k;
            } else {
                int k = j;
                while (k > i && height[k] <= height[j]) {
                    //找到比height[j]大的
                    k--;
                }
                j = k;
            }
        }
        return max;
    }
    
    /**
     * 264. Ugly Number II
     * Write a program to find the n-th ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
     * <p>
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
     * <p>
     * Note that 1 is typically treated as an ugly number.
     * 剑指offer上好像有类似题目
     *
     * @param n int
     * @return the Nth
     */
    public int nthUglyNumber(int n) {
        if (n < 1) return 0;
        if (n <= 6) return n;
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(2);
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(3);
        List<Integer> l5 = new ArrayList<Integer>();
        l5.add(5);
        int i2 = 0, i3 = 0, i5 = 0;
        
        int ugly = 0;
        for (int i = 1; i < n; i++) {
            int u2 = l2.get(i2);
            int u3 = l3.get(i3);
            int u5 = l5.get(i5);
            ugly = Math.min(Math.min(u2, u3), u5);
            System.out.println(ugly + " " + l2 + " " + l3 + " " + l5);
            l2.add(ugly * 2);
            l3.add(ugly * 3);
            l5.add(ugly * 5);
            if (ugly == u2) {
                i2++;
            }
            if (ugly == u3) {
                i3++;
            }
            if (ugly == u5) {
                i5++;
            }
        }
        return ugly;
    }
    
    /**
     * 异或法
     *
     * @param nums int[]
     * @return 出现一次的数字
     */
    public int singleNumberI(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
    
    /**
     * 整个数列的数加起来取3的余数,就是那个特殊数在该位上的值
     * http://www.raychase.net/2573
     *
     * @param nums int[]
     * @return single num
     */
    public int singleNumberII2(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int c = 0;
            int mask = 1 << i; //mask第位为1,其余位全是0
            for (int j = 0; j < nums.length; j++) {
                int val = nums[j] & mask;
                if (val != 0) { //如果在该位上为1,则++
                    c++;
                }
            }
            if (c % 3 > 0) { //对3取余数,只可能是0 or 1
                ret |= mask;
            }
        }
        return ret;
    }
    
    /**
     * 137. Single Number II
     * every element appears three times except for one.
     * 使用map,key:count 出现3次则删除该key
     *
     * @param nums int[]
     * @return int
     */
    public int singleNumberII(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                int cnt = map.get(n);
                if (cnt == 2) {
                    map.remove(n);
                } else {
                    map.put(n, cnt + 1);
                }
            } else {
                map.put(n, 1);
            }
        }
        return map.keySet().iterator().next();
    }
    
    /**
     * https://discuss.leetcode.com/topic/2031/challenge-me-thx
     * 很惊艳的算法 This solution is awesome !
     *
     * @param nums int[]
     * @return int
     */
    public int singleNumberIIBuggy(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    
    /**
     * 数组中有两个数出现一次,其他都是两次,找出这两个数
     * 先全部异或,根据结果,某位为1划分成两组
     * 再各组异或 各求出出现一次的数
     *
     * @param nums int[]
     * @return 两个出现一次的数字
     */
    public int[] singleNumberIII(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length <= 3) {
            return nums;
        }
        int or = 0;
        for (int n : nums) {
            or ^= n;
        }
        int i = indexOfOne(or);
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for (int n : nums) {
            if (isOne(n, i)) {
                list1.add(n);
            } else {
                list2.add(n);
            }
        }
        int res1 = 0;
        for (int n : list1) {
            res1 ^= n;
        }
        int res2 = 0;
        for (int n : list2) {
            res2 ^= n;
        }
        int[] res = new int[]{res1, res2};
        System.out.println(Arrays.toString(res));
        return res;
    }
    
    /**
     * 数字n bits 最右出现1的index
     *
     * @param n n
     * @return index
     */
    private int indexOfOne(int n) {
        int i = 0;
        if (n == 0) {
            return i;
        }
        while (true) {
            if ((n & 1) == 1) {
                return i;
            }
            i++;
            n = n >> 1;
        }
    }
    
    /**
     * n bits 第i位是否是1
     *
     * @param n n
     * @param i index
     * @return true false
     */
    private boolean isOne(int n, int i) {
        while (i > 0) {
            n = n >> 1;
            i--;
        }
        return (n & 1) == 1;
    }
    
    //奇数变偶数
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int s = 0;
        int len = 0;
        for (int i = 0; i <= num; i++) {
            if (i <= 1) {
                res[i] = i;
            } else {
                if ((i & 1) == 1) {
                    //偶变奇,+1
                    res[i] = res[i - 1] + 1;
                } else {
                    //奇变偶
                    if (s > 0 && (i - len) < s) {
                        //根据之前计算的结果赋值
                        res[i] = res[i - len];
                    } else {
                        res[i] = hammingWeight(i);
                        if (res[i] == 1) {
                            s = i;
                            len = i - 1;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    /**
     * 汉明权重 数字n bits中1的个数
     *
     * @param n 数字n
     * @return number of bits 1
     */
    private int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
    
    
    /**
     * n = a + b + c, maximize the product of those integers n >= 2 找3
     * There is a simple O(n) solution to this problem.
     * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
     *
     * @param n n
     * @return max multiply
     */
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int max = 1;
        while (n > 3) {
            n = n - 3;
            if (n <= 1) {
                max *= (n + 3);
            } else {
                max *= 3;
            }
        }
        max *= n;
        return max;
    }
    
    public void sortColors(int[] nums) {
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;
        for (int n : nums) {
            if (n == 0) i0++;
            if (n == 1) i1++;
            if (n == 2) i2++;
        }
        int index = 0;
        for (int i = 0; i < i0; i++) {
            nums[index] = 0;
            index++;
        }
        for (int i = 0; i < i1; i++) {
            nums[index] = 1;
            index++;
        }
        for (int i = 0; i < i2; i++) {
            nums[index] = 2;
            index++;
        }
        
        System.out.println(Arrays.toString(nums));
    }
    
    /**
     * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3] > nums[4]....
     * 奇偶有序
     *
     * @param nums int[]
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums) {
            list.add(n);
        }
        Collections.sort(list);
        int j = len - 1;
        for (int i = 1; i < len; i += 2, j--) {
            nums[i] = list.get(j);
        }
        for (int i = 0; i < len; i += 2, j--) {
            nums[i] = list.get(j);
        }
        
        
        System.out.println(Arrays.toString(nums));
    }
    
    public int findKthLargestHeap(int[] nums, int k) {
        initHeap(nums, nums.length);
        for (int i = nums.length - 1; i >= 1; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            minHeapFixdown(nums, 0, i);
        }
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }
    
    private void initHeap(int[] a, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapFixdown(a, i, n);
        }
    }
    
    private void minHeapFixdown(int a[], int i, int n) {
        int j = 2 * i + 1;
        int temp = a[i];
        while (j < n) {
            if (j + 1 < n && a[j + 1] < a[j]) j++;
            if (a[j] >= temp) break;
            a[i] = a[j];
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }
    
    //另:topk 堆排序
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int n : nums) {
            list.add(n);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return list.get(k - 1);
    }
    
    //treemap 按照值排序
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                Integer val = map.get(n);
                map.put(n, val + 1);
            } else {
                map.put(n, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
    
    /**
     * 输入号码,输出所有的字母组合
     *
     * @param digits string
     * @return list
     */
    public List<String> letterCombinations(String digits) {
        String nums = "0123456789";
        String[] letters = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> seqs = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            int index = nums.indexOf(ch);
            String str = letters[index];
            if (str != null) {
                seqs.add(str);
            }
        }
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < seqs.size(); i++) {
            String str = seqs.get(i);
            if (list.isEmpty()) {
                for (char ch : str.toCharArray()) {
                    list.add(String.valueOf(ch));
                }
            } else {
                List<String> tmp = new ArrayList<String>();
                for (String s : list) {
                    for (char ch : str.toCharArray()) {
                        tmp.add(s + ch);
                    }
                }
                list = tmp;
            }
        }
        System.out.println(list);
        return list;
    }
    
    /**
     * 最长回文
     *
     * @param s string
     * @return string
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String tmp = getPalindrome(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            tmp = getPalindrome(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }
    
    private String getPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
    
    /**
     * 模拟大正整数相乘
     *
     * @param num1 bigInteger
     * @param num2 bigInteger
     * @return multiply result
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String result = "";
        int fix = 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            int carry = 0;
            String line = "";
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int mul = (a * b) + carry;
                int num = mul % 10;
                carry = mul / 10;
                line = num + line;
            }
            if (carry > 0) {
                line = carry + line;
            }
            if (result.equals("")) {
                result = line;
            } else {
                //两行相加
                System.out.print(result + "+" + line + "=");
                String tmp = result.substring(result.length() - fix);
                int m = result.length() - fix - 1;
                int n = line.length() - 1;
                int c = 0;
                while (m >= 0 || n >= 0) {
                    int i1 = m < 0 ? 0 : result.charAt(m) - '0';
                    int i2 = n < 0 ? 0 : line.charAt(n) - '0';
                    int sum = i1 + i2 + c;
                    int num = sum % 10;
                    c = sum / 10;
                    tmp = num + tmp;
                    m--;
                    n--;
                }
                if (c > 0) {
                    //最高位有进位
                    tmp = c + tmp;
                }
                result = tmp;
                fix++;
            }
            System.out.println(result);
        }
        return result;
    }
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        int len = 0;
        int p = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                max = max < set.size() ? set.size() : max;
                set.clear();
                len = 0;
                if (p == 0) {
                    p = s.indexOf(ch);
                }
                i = s.indexOf(ch, p);
                p = i + 1;
            } else {
                set.add(ch);
                len++;
                max = max < len ? len : max;
            }
        }
        return max;
    }
    
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    private ListNode createListNode(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            node.next = next;
            node = next;
        }
        return head;
    }
    
    private void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
    
    /**
     * 2. Add Two Numbers
     * 链表模拟大数相加
     *
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 == null && l2 != null) {
                return l2;
            }
            if (l1 != null) {
                return l1;
            }
            return null;
        }
        
        ListNode head = null;
        ListNode node = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            if (head == null) {
                head = new ListNode(sum);
                node = head;
            } else {
                ListNode next = new ListNode(sum);
                node.next = next;
                node = next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode next = new ListNode(sum);
            node.next = next;
            node = next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode next = new ListNode(sum);
            node.next = next;
            node = next;
            l2 = l2.next;
        }
        
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return head;
    }
    
    /**
     * 80. Remove Duplicates from Sorted Array II
     * What if duplicates are allowed at most twice?
     * 重复的元素最多出现两次
     * [1,1,1,2,2,3] return 5 with the first five elements of nums being 1, 1, 2, 2 and 3.
     * It doesn't matter what you leave beyond the new length.
     *
     * @param nums int[]
     * @return len int
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        int i1 = 0;
        int i2 = 1;
        boolean dup = false;
        while (i2 < nums.length) {
            if (dup && nums[i1] == nums[i2]) {
                i2++;
                continue;
            }
            if (nums[i1] != nums[i2]) {
                dup = false;
                nums[++i1] = nums[i2];
                i2++;
                continue;
            }
            if (nums[i1] == nums[i2]) {
                dup = true;
                i1++;
                nums[i1] = nums[i2];
                i2++;
            }
        }
        return i1 + 1;
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int top = matrix[row][col]; // back top
                //left->top
                matrix[row][col] = matrix[n - col - 1][row];
                //bottom->left
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                //right->bottom
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                //top->right
                matrix[col][n - row - 1] = top;
            }
        }
    }
    
    /**
     * 39. Combination Sum
     * 从数组中选出序列,和为给定的target值,每个选中的数字不限次数
     * The same repeated number may be chosen from C unlimited number of times.
     * All numbers (including target) will be positive integers.
     *
     * @param candidates int[]
     * @param target     int sum
     * @return all combination
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(target, 0, candidates, ans, cur);
        return ans;
    }
    
    private void dfs(int target, int bd, int[] cand, List<List<Integer>> ans, List<Integer> cur) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        //Use bd (boundary) to avoid repeating cases.
        for (int i : cand) {
            if (i >= bd && (i == target || target - i >= bd)) {
                cur.add(i);
                dfs(target - i, i, cand, ans, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    /**
     * 动态规划，从下往上走
     *
     * @param triangle list<list<Integer>>
     * @return min
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        Integer[] dp = new Integer[triangle.get(m - 1).size()];
        triangle.get(m - 1).toArray(dp);
        for (int r = m - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                dp[c] = Math.min(dp[c], dp[c + 1]) + triangle.get(r).get(c);
            }
        }
        return dp[0];
    }
    
    //triangle数组可改变,直接在原数组上操作
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) {
            return 0;
        }
        for (int r = m - 2; r >= 0; r--) {
            for (int c = 0; c <= r; c++) {
                int v1 = triangle.get(r + 1).get(c);
                int v2 = triangle.get(r + 1).get(c + 1);
                triangle.get(r).set(c, Math.min(v1, v2) + triangle.get(r).get(c));
            }
        }
        return triangle.get(0).get(0);
    }
    
    
    //Best Time to Buy and Sell Stock
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int cur = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > cur) {
                profit += prices[i] - cur;
            }
            cur = prices[i];
        }
        return profit;
    }
    
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i] - min;
            if (cur > profit) {
                profit = cur;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return profit;
    }
    
    //双数组解法
    //http://blog.csdn.net/xudli/article/details/46911603
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = arr[i] * left;
            left = left * nums[i];
        }
        return arr;
    }
    
    public int[] productExceptSelf1(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    arr[j] = arr[j] * nums[i];
                }
            }
        }
        return arr;
    }
    
    //Solve it without division and in O(n).
    public int[] productExceptSelf2(int[] nums) {
        int all = 1;
        for (int i = 0; i < nums.length; i++) {
            all = all * nums[i];
        }
        
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = all / nums[i];
        }
        return arr;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int p = j + 1;
                int q = nums.length - 1;
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        List<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[p]);
                        tmpList.add(nums[q]);
                        list.add(tmpList);
                        p++;
                        q--;
                        
                        while (p < q && nums[p] == nums[p - 1]) {
                            p++;
                        }
                        while (p < q && nums[q] == nums[q + 1]) {
                            q--;
                        }
                    }
                }
            }
        }
        
        return list;
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            judgeAndPut(nums, i, i + 1, nums.length - 1, list);
        }
        return list;
    }
    
    private void judgeAndPut(int[] num, int i, int p, int q, List<List<Integer>> list) {
        while (p < q) {
            if (num[p] + num[q] + num[i] < 0) {
                p++;
            } else if (num[p] + num[q] + num[i] > 0) {
                q--;
            } else {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(num[i]);
                tmpList.add(num[p]);
                tmpList.add(num[q]);
                list.add(tmpList);
                p++;
                q--;
                while (p < q && num[p] == num[p - 1]) {
                    p++;
                }
                while (p < q && num[q] == num[q + 1]) {
                    q--;
                }
            }
        }
    }
    
    private void judgeAndPutWrong(int[] num, int i, int p, int q, List<List<Integer>> list) {
        while (p < q) {
            if (num[p] + num[q] + num[i] < 0) {
                p++;
            } else if (num[p] + num[q] + num[i] > 0) {
                q--;
            } else {
                List<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(num[i]);
                tmpList.add(num[p]);
                tmpList.add(num[q]);
                list.add(tmpList);
                p++;
                q--;
            }
            // 参考blog里面把两个while循环写在外面了,自己调试了好久发现应该放在里面
            // 注意 p-1 和 q+1 的逻辑,循环中直接判重
            // 当想留言说有错时,发现博主写的是对的,是自己看的时候粗心搞错了,o(╯□╰)o
            while (p < q && num[p] == num[p - 1]) {
                p++;
            }
            while (p < q && num[q] == num[q + 1]) {
                q--;
            }
        }
    }
    
    //http://blog.csdn.net/li4951/article/details/8693212
    public List<List<Integer>> threeSumWrong(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        
                        int max = nums[i] > nums[j] ? nums[k] > nums[i] ? nums[k] : nums[i] : nums[k] > nums[j] ? nums[k] : nums[j];
                        int min = nums[i] < nums[j] ? nums[k] < nums[i] ? nums[k] : nums[i] : nums[k] < nums[j] ? nums[k] : nums[j];
                        int mid = 0 - max - min;
                        
                        if (set.contains(min - mid - max)) {
                            break;
                        }
                        
                        List<Integer> subList = new ArrayList<Integer>(3);
                        subList.add(min);
                        subList.add(mid);
                        subList.add(max);
                        res.add(subList);
                        break;
                    }
                }
            }
        }
        return res;
    }
    
    //http://blog.csdn.net/ljiabin/article/details/39968583
    public String int2Roman(int num) {
        String[][] roman = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};
        String res = "";
        int digit = 0;
        while (num != 0) {
            int t = num % 10;
            res = roman[digit][t] + res;
            digit++;
            num /= 10;
        }
        return res;
    }
    
    //http://blog.csdn.net/havenoidea/article/details/11848921
    public String intToRoman(int num) {
        String str = "";
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; i++) {
            while (num >= value[i]) {
                num -= value[i];
                str += symbol[i];
            }
        }
        return str;
    }
    
    //三层循环最原始的方法居然都AC
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    int newDiff = Math.abs(tmp - target);
                    if (newDiff < diff) {
                        diff = newDiff;
                        res = tmp;
                        if (res == target) {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public int threeSumClosestNew(int[] num, int target) {
        int closest = 0;
        boolean needInit = true;
        Arrays.sort(num); //排序从两头找
        for (int i = 0; i <= num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = num.length - 1;
            while (p < q) {
                int sum = num[i] + num[p] + num[q];
                if (needInit || Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                needInit = false;
                if (sum <= target) {
                    p++;
                    while (p < q && num[p] == num[p - 1]) {
                        p++;
                    }
                } else if (sum > target) {
                    q--;
                    while (p < q && num[q] == num[q + 1]) {
                        q--;
                    }
                }
            }
        }
        return closest;
    }
    
    /**
     * 1. Two Sum
     * 返回数组中和等于target的两个元素的索引序列
     *
     * @param nums   int[]
     * @param target int
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.get(tmp) != null) {
                res[0] = map.get(tmp) + 1;
                res[1] = i + 1;
            } else {
                //将已遍历数字放入map中 num:index
                map.put(nums[i], i);
            }
        }
        return res;
    }
    
    /**
     * 先排序,从两头查找,再循环原始数组找到索引 效率比较低
     * 不如上面用Hashmap的方式直接查询索引
     *
     * @param nums   int[]
     * @param target int
     * @return int[]
     */
    public int[] twoSumSort(int[] nums, int target) {
        int len = nums.length;
        int[] sorted = new int[len];
        System.arraycopy(nums, 0, sorted, 0, len);
        Arrays.sort(sorted);
        int i = 0;
        int j = len - 1;
        int p = 0;
        int q = 0;
        while (i < j) {
            p = sorted[i];
            q = sorted[j];
            if (p + q > target) {
                j--;
            } else if (p + q < target) {
                i++;
            } else {
                break;
            }
        }
        int[] res = new int[]{-1, -1};
        for (int n = 0; n < len; n++) {
            if (nums[n] == p && res[0] == -1) {
                res[0] = n;
            } else if (nums[n] == q && res[1] == -1) {
                res[1] = n;
            }
        }
        
        return res;
    }
}
