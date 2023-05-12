package com.scaler.twopointers;

import java.util.Arrays;

public class SubArrayWithGivenSum {


    public static int[] solve(int[] A, int B) {

        int n=A.length;

        if(n==1){
            if (A[0] != B) {
                A[0] = -1;
            }
            return A;
        }
        int start=0;

        int sum=A[start];

        for(int i=1;i<=n;i++){

            while (sum>B && start<i-1){
                sum-=A[start];
                start++;
            }
            if(sum==B){
                int[] arr=Arrays.copyOfRange(A,start,i);
                return arr;
            }
            if(i<n){
                sum+=A[i];
            }

        }
        return new int[]{-1};

    }


    public static void main(String[] args) {

        //int[] arr={501, 503, 516, 525, 527, 534, 538, 541, 546, 548, 557, 558, 561, 566, 567, 569, 578, 580, 587, 591, 601, 606, 615, 630, 640, 664, 679, 682, 683, 685, 691, 698, 702, 707, 717, 721, 726, 728, 729, 731, 734, 743, 744, 753, 756, 760, 771, 772, 774, 777, 778, 783, 786, 801, 808, 812, 814, 815, 820, 833, 841, 849, 854, 855, 856, 864, 865, 871, 873, 878, 880, 882, 883, 896, 907, 911, 917, 919, 921, 931, 949, 950, 954, 958, 959, 978, 987, 989, 990, 991, 999, 1002, 1009, 1012, 1016, 1017, 1018, 1022, 1025, 1030, 1033, 1037, 1051, 1052, 1054, 1058, 1066, 1071, 1073, 1081, 1085, 1089, 1102, 1106, 1117, 1119, 1125, 1133, 1135, 1139, 1144, 1157, 1159, 1168, 1179, 1181, 1183, 1185, 1187, 1189, 1195, 1196, 1208, 1212, 1224, 1225, 1230, 1234, 1237, 1238, 1241, 1244, 1247, 1249, 1255, 1258, 1259, 1261, 1263, 1264, 1268, 1288, 1292, 1294, 1296, 1299, 1303, 1304, 1320, 1323, 1324, 1327, 1335, 1341, 1342, 1356, 1364, 1366, 1367, 1369, 1370, 1371, 1374, 1386, 1389, 1391, 1399, 1409, 1414, 1420, 1421, 1426, 1433, 1434, 1452, 1454, 1464, 1466, 1472, 1482, 1484, 1486, 1493, 1495, 1507, 1510, 1512, 1524, 1525, 1532, 1541, 1547, 1550, 1555, 1561, 1567, 1576, 1577, 1581, 1585, 1594, 1595, 1596, 1597, 1600, 1620, 1627, 1635, 1643, 1644, 1654, 1655, 1658, 1660, 1662, 1663, 1665, 1670, 1680, 1681, 1690, 1691, 1694, 1701, 1702, 1704, 1706, 1711, 1716, 1718, 1723, 1731, 1734, 1737, 1745, 1747, 1753, 1764, 1766, 1771, 1772, 1782, 1783, 1784, 1787, 1794, 1800, 1801, 1806, 1809, 1816, 1818, 1823, 1830, 1834, 1839, 1845, 1860, 1867, 1870, 1874, 1877, 1879, 1897, 1900, 1902, 1903, 1908, 1910, 1921, 1922, 1940, 1943, 1957, 1960, 1961, 1965, 1973, 1977, 1985, 1986, 1988, 1990, 1995};
       //90, 991, 999, 1002, 1009, 1012, 1016, 1017, 1018, 1022, 1025, 1030, 1033, 1037, 1051, 1052, 1054, 1058, 1066, 1071, 1073, 1081, 1085, 1089, 1102, 1106, 1117, 1119, 1125, 1133, 1135, 1139, 1144, 1157, 1159, 1168, 1179, 1181, 1183, 1185, 1187, 1189, 1195, 1196, 1208, 1212, 1224, 1225, 1230, 1234, 1237, 1238, 1241, 1244, 1247, 1249, 1255, 1258, 1259, 1261, 1263, 1264, 1268, 1288, 1292, 1294, 1296, 1299, 1303, 1304, 1320, 1323, 1324, 1327, 1335, 1341, 1342, 1356, 1364, 1366, 1367, 1369, 1370, 1371, 1374, 1386, 1389, 1391, 1399, 1409, 1414, 1420, 1421, 1426, 1433, 1434, 1452, 1454, 1464, 1466, 1472, 1482, 1484, 1486, 1493, 1495, 1507, 1510, 1512, 1524, 1525, 1532, 1541, 1547, 1550, 1555, 1561, 1567, 1576, 1577, 1581, 1585, 1594, 1595, 1596, 1597, 1600, 1620, 1627, 1635, 1643, 1644, 1654, 1655, 1658, 1660, 1662, 1663, 1665, 1670, 1680, 1681, 1690, 1691, 1694, 1701, 1702, 1704, 1706, 1711, 1716, 1718, 1723, 1731, 1734, 1737, 1745, 1747, 1753, 1764, 1766, 1771, 1772, 1782, 1783, 1784, 1787, 1794, 1800, 1801, 1806, 1809, 1816, 1818, 1823, 1830, 1834, 1839, 1845, 1860, 1867, 1870, 1874, 1877, 1879, 1897, 1900, 1902, 1903, 1908, 1910, 1921, 1922, 1940, 1943, 1957, 1960, 1961, 1965, 1973, 1977, 1985, 1986, 1988, 1990, 1995};
        //int [] arr= {5, 10, 20, 100, 105};
        int [] arr= {1,1000000000};
        int target=1000000000;
        //int[] arr={ 42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37 };
       // int target=2818;
        System.out.println(Arrays.toString((solve(arr,target))));
    }
}