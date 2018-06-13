package com.ryl.learn.lecode;

import jodd.madvoc.meta.In;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import scala.Char;

import java.util.*;

/**
 * Easy code 003
 * Created on 17/1/22 09:48.
 */
public class EasyNew {
    
    public static void main(String[] args) {
        EasyNew easyNew = new EasyNew();
        System.out.println(easyNew.hammingDistance(1, 4));
        System.out.println(easyNew.hammingWeight(-1));
        
        System.out.println(easyNew.findComplement(1));
        System.out.println(easyNew.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        
        System.out.println(easyNew.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(easyNew.findDisappearedNumbers(new int[]{1, 1}));
        
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(easyNew.islandPerimeter(grid));
        
        System.out.println(Arrays.toString(easyNew.constructRectangle(4)));
        
        System.out.println(easyNew.numberOfBoomerangs(new int[][]{
                {0, 0}, {1, 0}, {2, 0}
        }));
        
        
        System.out.println(easyNew.countSegments("     "));
        
        System.out.println(easyNew.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        
        System.out.println(easyNew.arrangeCoins(3));
        System.out.println(easyNew.arrangeCoins(1804289383));
        
        
        System.out.println(Arrays.toString(easyNew.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(easyNew.findWords(new String[]{"asdfghjklASDFGHJKL", "qwertyuiopQWERTYUIOP", "zxcvbnmZXCVBNM"})));
        
        System.out.println(Arrays.toString(easyNew.nextGreaterElement(
                new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}
        )));
        
        System.out.println(Arrays.toString(easyNew.nextGreaterElement(
                new int[]{2, 4}, new int[]{1, 2, 3, 4}
        )));
        System.out.println(easyNew.detectCapitalUse("aFFF"));
        
        System.out.println(Arrays.toString(easyNew.findRelativeRanks(new int[]{1, 3, 4, 6, 7, 2, 10, 9, 8})));
        
        System.out.println(easyNew.findContentChildren(new int[]{494, 324, 293, 199, 164, 32, 428, 155, 229, 452, 99, 433, 189, 47, 15, 37, 199, 81, 16, 110, 318, 253, 79, 31, 92, 337, 251, 448, 463, 178, 418, 399, 466, 284, 311, 403, 337, 89, 322, 405, 507, 367, 278, 173, 366, 399, 145, 125, 444, 505, 38, 181, 349, 194, 253, 521, 86, 353, 493, 514, 385, 273, 128, 526, 449, 420, 478, 184, 361, 444, 392, 359, 463, 395, 275, 436, 378, 363, 242, 396, 32, 140, 321, 137, 207, 130, 179, 185, 402, 160, 332, 57, 34, 80, 99, 497, 479, 317, 25, 173, 64, 314, 276, 504, 354, 430, 261, 247, 40, 266, 55, 301, 243, 184, 181, 313, 102, 487, 132, 478, 185, 223, 117, 141, 333, 353, 403, 184, 209, 188, 426, 8, 297, 314, 503, 143, 195, 513, 279, 54, 399, 17, 201, 281, 346, 122, 141, 183, 369, 330, 469, 56, 292, 65, 447, 120, 414, 279, 515, 382, 78, 290, 306, 420, 3, 113, 292, 426, 252, 100, 248, 157, 158, 320, 507, 61, 13, 143, 33, 321, 316, 48, 470, 345, 524, 429, 139, 439, 41, 433, 170, 168, 30, 422, 41, 79, 521, 222, 193, 115, 44, 121, 279, 226, 516, 188, 298, 130, 2, 438, 196, 277, 186, 401, 77, 285, 228, 167, 316, 500, 397, 286, 391, 11, 454, 453, 441, 60, 520, 107, 407, 134, 480, 327, 213, 217, 177, 494, 40, 337, 360, 74, 435, 16, 485, 33, 206, 237, 432, 181, 183, 197, 174, 241, 363, 474, 12, 21, 3, 190, 388, 182, 261, 447, 133, 514, 68, 91, 65, 232, 309, 272, 30, 50, 226, 70, 171, 306, 281, 312, 186, 491, 459, 485, 251, 115, 315, 54, 497, 488, 97, 79, 80, 342, 402, 308, 99, 132, 255, 98, 297, 64, 408, 396, 485, 325, 24, 422, 306, 395, 519, 279, 386, 316, 127, 41, 435, 463, 433, 158, 35, 123, 526, 458, 321, 4, 161, 502, 429, 423, 201, 219, 223, 222, 324, 273, 481, 146, 440, 195, 263, 384, 19, 393, 123, 414, 515, 286, 234, 526, 288, 381, 173, 177, 7, 238, 372, 111, 191, 207, 218, 479, 363, 32, 429, 507, 223, 175, 407, 455, 209, 282, 105, 71, 269, 158, 324, 84, 494, 42, 474, 79, 312, 295, 269, 3, 437, 505, 200, 389, 102, 301, 174, 71, 462, 361, 259, 409, 204, 258, 237, 154, 210, 205, 63, 378, 57, 280, 189, 287, 373, 188, 192, 444, 213, 66, 458, 293, 82, 143, 57, 396, 33, 277, 87, 498, 93, 329, 80, 171, 89, 180, 86, 485, 97, 122, 279, 256, 238, 456, 403, 145, 441, 174, 112, 498, 320, 100, 430, 440, 261, 174, 333, 157, 501, 132, 378, 320, 512, 161, 252, 13, 135, 240, 5, 25, 144, 444, 150, 189, 331, 142, 412, 363, 364, 385, 157, 16, 442, 15, 51, 314, 461, 446, 13, 53, 116, 340, 414, 14, 82, 471, 133, 482, 11, 335, 487, 308, 475, 376, 410, 181, 473, 138, 401, 329, 86, 34, 95, 66, 105, 374, 421, 447, 198, 203, 437, 517, 382, 369, 410, 76, 178, 308, 240, 144, 270, 492, 128, 384, 438, 426, 366, 361, 330, 128, 275, 383, 111, 379, 418, 282, 43, 335, 409, 212, 466, 471, 285, 221, 464, 330, 327, 166, 197, 324, 294, 459, 150, 169, 227, 262, 297, 262, 73, 138, 479, 141, 92, 19, 253, 259, 198, 230, 381, 400, 414, 235, 1, 9, 390, 196, 98, 326, 340, 324, 420, 490, 222, 9, 353, 314, 223, 235, 208, 348, 302, 481, 393, 225, 400, 165, 357, 443, 253, 16, 400, 344, 393, 269, 378, 183, 329, 304, 426, 346, 323, 441, 404, 263, 468, 500, 430, 406, 372, 289, 216, 213, 500, 260, 517, 448, 488, 490, 348, 487, 100, 41, 398, 96, 283, 393, 48, 58, 5, 257, 276, 207, 487, 344, 406, 339, 368, 267, 328, 491, 158, 410, 159, 434, 399, 264, 81, 159, 293, 77, 225, 526, 42, 160, 305, 8, 204, 62, 178, 316, 265, 216, 503, 423, 135, 72, 329, 111, 103, 172, 508, 62, 421, 194, 28, 90, 237, 281, 136, 68, 411, 373, 462, 406, 144, 426, 497, 86, 161, 307, 510, 334, 121, 501, 81, 268, 3, 369, 336, 285, 167, 429, 259, 143, 479, 201, 175, 110, 141, 460, 263, 206, 120, 92, 22, 244, 314, 268, 399, 322, 102, 266, 328, 254, 83, 256, 474, 278, 186, 469, 304, 376, 371, 175, 520, 428, 455, 111, 489, 319, 110, 286, 166, 89, 211, 314, 77, 121, 415, 317, 465, 340, 121, 284, 519, 488, 344, 233, 339, 341, 278, 246, 137, 517, 111, 150, 34, 271, 509, 379, 517, 351, 262, 161, 189, 365, 292, 462, 341, 374, 287, 29, 299, 239, 432, 407, 377, 447, 71, 326, 173, 237, 311, 451, 255, 395, 221, 470, 81, 374, 275, 38, 454, 210, 360, 189, 193, 133, 214, 380, 220, 43, 197, 282, 47, 300, 124, 298, 103, 32, 32, 205, 28, 53, 361, 42, 253, 230, 148, 389, 286, 250, 330, 184, 513, 525, 42, 32, 175, 303, 492, 286, 406, 69, 510, 456, 83, 105, 342, 367, 265, 4, 201, 249, 294, 102, 205, 273, 484, 228, 71, 395, 271, 421, 344, 341, 155, 525, 278, 82, 137, 359, 381, 269, 279, 421, 4, 43, 469, 522, 280, 394, 468, 85, 478, 188, 312, 124, 95, 36, 183, 484, 458, 271, 202, 213, 319, 332, 73, 497, 443, 161, 132, 88, 67, 280, 90, 480, 197, 296, 181, 145, 9, 440, 439, 52, 331, 231, 249, 109, 244, 462, 500, 506, 501, 503, 96, 478, 158, 224, 200, 386, 432, 195, 202, 222, 438, 383, 462, 8, 312, 251, 246, 425},
                new int[]{383, 384, 347, 280, 433, 481, 462, 56, 487, 9, 162, 245, 485, 90, 380, 257, 364, 383, 451, 146, 48, 6, 366, 333, 490, 319, 438, 147, 212, 156, 296, 298, 241, 239, 36, 13, 187, 475, 154, 89, 399, 301, 175, 460, 143, 209, 237, 49, 5, 341, 115, 427, 92, 49, 304, 401, 283, 277, 251, 464, 171, 217, 369, 244, 495, 295, 422, 408, 20, 319, 113, 488, 27, 452, 302, 203, 373, 304, 160, 521, 92, 378, 317, 491, 232, 520, 182, 483, 270, 423, 298, 433, 264, 226, 283, 389, 23, 323, 364, 343, 60, 351, 282, 44, 306, 436, 273, 19, 330, 217, 89, 163, 445, 291, 439, 506, 107, 228, 436, 438, 16, 133, 197, 42, 145, 450, 100, 341, 98, 248, 94, 10, 30, 332, 518, 315, 111, 67, 85, 131, 296, 489, 32, 54, 249, 127, 211, 177, 328, 216, 511, 177, 185, 463, 386, 163, 43, 245, 435, 163, 70, 327, 503, 276, 101, 371, 58, 230, 410, 174, 187, 271, 144, 45, 335, 45, 140, 499, 2, 474, 512, 27, 260, 91, 52, 160, 49, 346, 180, 150, 59, 495, 42, 483, 275, 310, 351, 89, 135, 155, 76, 317, 495, 311, 185, 134, 396, 108, 240, 217, 417, 513, 317, 269, 316, 412, 390, 23, 259, 132, 407, 465, 283, 84, 173, 406, 425, 101, 106, 525, 379, 105, 202, 366, 410, 15, 344, 475, 519, 353, 275, 89, 415, 59, 452, 354, 118, 293, 484, 286, 81, 130, 359, 269, 223, 147, 511, 326, 418, 68, 321, 219, 331, 14, 374, 110, 4, 350, 446, 379, 105, 484, 209, 95, 505, 185, 509, 498, 248, 136, 449, 289, 54, 430, 399, 293, 311, 90, 93, 291, 113, 339, 47, 213, 181, 286, 239, 231, 495, 520, 318, 7, 437, 228, 83, 286, 24, 340, 358, 514, 339, 233, 303, 193, 239, 225, 239, 29, 434, 178, 109, 519, 434, 200, 413, 422, 42, 356, 255, 346, 429, 249, 484, 282, 346, 488, 408, 74, 2, 76, 239, 419, 230, 324, 511, 195, 396, 67, 427, 285, 273, 105, 226, 113, 318, 166, 224, 498, 382, 429, 170, 447, 92, 408, 386, 526, 302, 76, 10, 191, 488, 250, 133, 475, 42, 280, 479, 237, 492, 125, 344, 190, 390, 435, 461, 129, 494, 465, 441, 175, 252, 203, 205, 229, 87, 331, 88, 408, 43, 46, 238, 77, 37, 267, 121, 494, 157, 121, 347, 509, 511, 386, 132, 285, 112, 129, 287, 4, 18, 92, 188, 365, 241, 143, 4, 202, 78, 329, 496, 421, 194, 77, 45, 66, 466, 520, 268, 498, 40, 385, 525, 213, 375, 477, 58, 35, 357, 322, 311, 48, 526, 496, 403, 516, 162, 424, 518, 88, 486, 252, 89, 327, 365, 282, 512, 339, 487, 492, 501, 54, 521, 117, 475, 317, 254, 362, 247, 77, 201, 119, 304, 492, 305, 161, 133, 493, 45, 398, 42, 31, 476, 486, 93, 191, 183, 149, 258, 7, 125, 316, 93, 384, 440, 82, 512, 37, 151, 228, 328, 39, 21, 166, 447, 311, 351, 66, 122, 320, 48, 176, 281, 384, 145, 313, 187, 29, 327, 186, 489, 400, 391, 20, 243, 200, 333, 42, 496, 253, 292, 76, 105, 128, 182, 241, 284, 406, 247, 203, 42, 342, 375, 53, 383, 200, 461, 453, 144, 187, 313, 154, 349, 369, 48, 267, 154, 149, 423, 362, 426, 271, 507, 28, 197, 312, 107, 364, 45, 211, 260, 337, 347, 501, 78, 101, 390, 44, 247, 323, 101, 435, 442, 66, 442, 11, 204, 24, 121, 458, 347, 304, 234, 340, 500, 364, 103, 418, 24, 211, 59, 253, 95, 285, 177, 472, 425, 16, 315, 146, 497, 187, 108, 114, 47, 451, 171, 228, 518, 35, 411, 142, 63, 125, 28, 241, 157, 502, 503, 236, 82, 434, 481, 48, 494, 501, 45, 349, 179, 451, 246, 253, 526, 15, 203, 156, 482, 134, 78, 36, 284, 146, 45, 142, 113, 357, 75, 510, 131, 482, 362, 133, 148, 100, 147, 112, 343, 304, 50, 482, 348, 496, 337, 498, 468, 448, 326, 107, 219, 122, 360, 2, 476, 16, 479, 524, 34, 384, 160, 441, 353, 370, 48, 71, 255, 50, 131, 306, 419, 238, 505, 501, 470, 136, 235, 409, 215, 153, 148, 82, 120, 478, 403, 352, 341, 112, 466, 102, 75, 116, 426, 69, 129, 294, 178, 136, 498, 29, 487, 492, 343, 449, 132, 71, 218, 501, 27, 410, 449, 352, 410, 337, 152, 374, 342, 456, 418, 520, 91, 461, 317, 467, 498, 163, 227, 202, 449, 158, 218, 215, 30, 361, 333, 315, 171, 140, 2, 233, 67, 411, 104, 108, 415, 381, 478, 167, 111, 441, 413, 95, 238, 524, 35, 256, 147, 97, 85, 444, 227, 324, 93, 431, 57, 326, 378, 51, 31, 272, 91, 183, 237, 304, 198, 414, 502, 136, 109, 154, 258, 327, 165, 523, 10, 269, 97, 515, 518, 242, 171, 379, 136, 425, 302, 412, 458, 366, 244, 177, 276, 122, 108, 41, 61, 233, 413, 391, 180, 492, 469, 117, 280, 22, 488, 473, 188, 3, 108, 30, 346, 423, 230, 412, 53, 464, 491, 16, 476, 457, 120, 149, 259, 254, 458, 336, 366, 129, 111, 479, 153, 169, 150, 376, 260, 477, 218, 79, 307, 349, 440, 46, 426, 381, 67, 409, 437, 425, 231, 31, 237, 197, 477, 304, 218, 393, 70, 221, 199, 312, 514, 61, 76, 193, 226, 428, 516, 298, 479, 124, 149, 116, 222, 436, 314, 101, 224, 370, 11, 297, 361, 32, 273, 490, 115, 39, 181, 453, 31, 401, 295, 58, 327, 440, 175, 169, 133, 384, 103, 166, 283, 80, 360, 464, 51, 82, 109, 140, 43, 74, 209, 357, 275, 359, 340, 247, 454, 415, 136, 227, 350, 100, 399, 396, 510, 318, 22, 239, 461, 485, 60, 345, 7, 443, 25, 374, 85, 467, 272, 278, 387, 29, 94, 461, 232, 518, 318, 206, 460, 401, 168, 17, 406, 190, 385, 68, 55, 428, 348, 288, 55, 272, 290, 265, 118, 372, 504, 490, 142, 218, 360, 422, 350, 317, 515, 107, 167, 150, 508, 454, 152, 475, 34, 246, 483, 177, 80, 227, 423, 358, 75, 197, 481, 510, 130, 116, 402, 18, 110, 157, 22, 114, 122, 359, 237, 190, 167, 96, 432, 24, 58, 358, 470, 465, 57, 285, 163, 226, 257, 83, 57, 298, 524, 237, 45, 39, 452, 170, 301, 478, 1, 341, 476, 293, 170, 510, 390, 330, 149, 271, 499, 213, 61, 91, 95, 98, 9, 340, 78, 79, 46, 438, 456, 272, 481, 479, 306, 321, 368, 27, 10, 136, 394, 387, 216, 29, 458, 136, 278, 423, 164, 400, 520, 356, 201, 352, 19, 188, 33, 229, 289, 105, 273, 251, 516, 505, 285, 88, 291, 305, 213, 173, 470, 383, 239, 504, 190, 242, 305, 500, 208, 484, 242, 377, 325, 409, 2, 29, 343, 8, 488, 526, 54, 449, 80, 313, 511, 396, 204, 15, 377, 14, 475, 267, 94, 217, 294, 392, 34, 133, 79, 91, 260, 84, 295, 263, 449, 456, 278, 436, 18, 114, 436, 491, 509, 46, 198, 46, 377, 128, 357, 97, 188, 216, 293, 111, 498, 33, 22, 84, 41, 520, 312, 470, 442, 404, 86, 75, 213, 274, 45, 223, 73, 54, 199, 289, 81, 93, 31, 67, 97, 461, 91, 515, 285, 280, 139, 126, 370, 142, 196, 192, 392, 4, 422, 172, 304, 393, 352, 156, 105, 514, 106, 510, 337, 255, 167, 95, 424, 339, 455, 102, 81, 179, 391, 185, 410, 404, 368, 494, 398, 290, 20, 525, 218, 395, 194}));
        
        System.out.println(easyNew.convertToBase7(100));
        System.out.println(easyNew.convertToBase7(-7));
        
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(easyNew.getMinimumDifference(root));
        
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        System.out.println(easyNew.getMinimumDifference(root));
        
        System.out.println(easyNew.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(easyNew.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(easyNew.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(easyNew.findPairs(new int[]{1, 1, 1, 1, 1}, 0));
        
        System.out.println(easyNew.reverseStr("abcdefg", 2));
        
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        root.right = new TreeNode(3);
        
        System.out.println(easyNew.diameterOfBinaryTree(root));
        
        easyNew.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        easyNew.rotate(new int[]{1, 2}, 3);
        
        
        System.out.println(easyNew.checkRecord("ALLPPPLLLPPLPLPLL"));
        System.out.println(easyNew.checkRecord("LL"));
    }
    
    @Test
    public void maximumProductTest() {
        System.out.println(maximumProduct(new int[] {1, 2, 3}));
        System.out.println(maximumProduct(new int[] {1, 2, 3, 4}));
        System.out.println(maximumProduct(new int[] {-12, -10, -5, 0, 5, 7, 10}));
    }
    
    /**
     * 628. 三个数的最大乘积
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * 
     * @param nums 数组
     * @return 最大乘积
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        
        if (nums[len - 1] <= 0 || nums[0] >= 0) {
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        }
        
        //有正有负
        int max = nums[len - 1] * nums[len - 2] * nums[len - 3];
        if (nums[1] < 0) {
            max = Math.max(max, nums[0] * nums[1] * nums[len - 1]);
        }
        return max;
    }
    
    @Test
    public void largeGroupPositionsTest() {
        List<List<Integer>> list = largeGroupPositions("abbxxxxzyy");
        list.forEach(
                System.out::println
        );
        
    }
    
    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组
     * 所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
     * 最终结果按照字典顺序输出。
     * 
     * @param S 字符串
     * @return 分组
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        if (S.length() <= 1) {
            List<Integer> sub = new ArrayList<>();
            sub.add(0);
            result.add(sub);
            return result;
        }
        
        class Node implements Comparable<Node> {
            char ch;
            int i;
            int j;
    
            public Node(char ch) {
                this.ch = ch;
            }
    
            public Node(char ch, int i, int j) {
                this.ch = ch;
                this.i = i;
                this.j = j;
            }
    
            @Override
            public int compareTo(@NotNull Node o) {
                return this.ch - o.ch;
            }
    
            @Override
            public String toString() {
                return "Node{" +
                        "ch=" + ch +
                        ", i=" + i +
                        ", j=" + j +
                        '}';
            }
        }
        
        List<Node> list = new ArrayList<>();
        
        int i = 0;
        while (i < S.length()) {
            char ch = S.charAt(0);
            int j = 1;
            
            list.add(new Node(S.charAt(i)));
        }
        Collections.sort(list);
        list.forEach(
               node -> {
                   List<Integer> sub = new ArrayList<>();
                   sub.add(node.i);sub.add(node.j);
                   result.add(sub);
               }
        );
        return result;
    }
    
    @Test
    public void findMaxAverageTest() {
        System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[] {4, 2, 1, 3, 3}, 2));
    }
    
    /**
     * 643. 子数组最大平均数 I
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数
     * 
     * @param nums  整数数组
     * @param k     长度 
     * @return 最大平均数
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        while (i < k) {
            sum += nums[i];
            i++;
        }
        double average = (double) sum / k;
        
        for (; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            double temp = (double) sum / k;
            if (temp > average) {
                average = temp;
            }
        }
        return average;
    }
    
    @Test
    public void findUnsortedSubarrayTest() {
        System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[] {1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[] {1, 3, 2, 4, 5}));
    }
    
    /**
     * 581. 最短无序连续子数组
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序
     *
     * @param nums 数组
     * @return 最短数组长度
     */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);
        int i = 0;
        while (i < nums.length && nums[i] == copy[i]) {
            i++;
        }
        int j = nums.length - 1;
        while (j > 0 && j > i && nums[j] == copy[j]) {
            j--;
        }
        return j - i + 1;
    }
    
    @Test
    public void canPlaceFlowersTest() {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 1, 0}, 1));
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }
    
    /**
     * 605. 种花问题
     * flowerbed = [1,0,0,0,1], n = 1 True
     * flowerbed = [1,0,0,0,1], n = 2 False
     * 求出最多可插入多少朵花，与n比较
     *
     * @param flowerbed 花卉素组
     * @param n         种入的n朵花
     * @return true/false
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean flag = true;
                if (i > 0) {
                    flag = flowerbed[i - 1] == 0;
                }
                if (i < flowerbed.length - 1) {
                    flag = flag && flowerbed[i + 1] == 0;
                }
                if (flag) {
                    flowerbed[i] = 1;
                    cnt++;
                }
                if (cnt >= n) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Test
    public void checkPossibilityTest() {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
        
    }
    
    /**
     * 665. 非递减数列
     * <p>
     * 判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列
     * 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]
     *
     * @param nums int[]
     * @return true/false
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
            if (cnt == 1) {
                //一次递减，看能不能包住
                int tmp = Math.min(nums[i - 1], i - 2 >= 0 ? nums[i - 2] : nums[i]);
                if (tmp <= nums[i]) {
                    nums[i - 1] = tmp;
                    continue;
                }
                tmp = Math.max(nums[i - 1], i + 1 < nums.length ? nums[i + 1] : nums[i]);
                if (tmp >= nums[i - 1]) {
                    nums[i] = tmp;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void pivotIndexTest() {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, 0, -1, -1}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, -1}));
    }
    
    /**
     * 724. 寻找数组的中心索引
     * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和
     * 如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
     *
     * @param nums 整数类型的数组
     * @return 中心索引
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        
        int left = 0;
        int index = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        while (index < nums.length) {
            if (left == right) {
                return index;
            }
            left += nums[index];
            index++;
            if (index >= nums.length) {
                break;
            }
            right -= nums[index];
        }
        return -1;
    }
    
    
    @Test
    public void numMagicSquaresInsideTest() {
        System.out.println(numMagicSquaresInside(new int[][]{
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        }));
        
        System.out.println(isMagicSquare(new int[][]{
                {4, 3, 8},
                {9, 5, 1},
                {2, 7, 6}
        }, 0, 0));
    }
    
    /**
     * 840. 矩阵中的幻方
     * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等
     *
     * @param grid int[][]
     * @return 多少个 3 × 3 的 “幻方” 子矩阵
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean isMagicSquare(int[][] grid, int rowStart, int colStart) {
        int row = grid.length;
        int col = grid[0].length;
        int rowEnd = rowStart + 2;
        int colEnd = colStart + 2;
        
        if (rowEnd >= row) {
            return false;
        }
        if (colEnd >= col) {
            return false;
        }
        int sum = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            int ss = 0;
            for (int j = colStart; j <= colEnd; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9) {
                    return false;
                }
                ss += num;
            }
            if (sum == 0) {
                sum = ss;
            } else if (sum != ss) {
                return false;
            }
        }
        int ss1 = 0;
        int ss2 = 0;
        for (int i = 0; i < 3; i++) {
            ss1 += grid[rowStart + i][colStart + i];
            ss2 += grid[rowStart + i][colEnd - i];
        }
        return sum == ss1 && sum == ss2;
    }
    
    @Test
    public void findLengthOfLCISTest() {
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
    }
    
    /**
     * 674. 最长连续递增序列
     * 找到最长且连续的的递增序列
     * 输入: [1,3,5,4,7] 输出: 3
     *
     * @param nums int[] 未经排序的整数数组
     * @return int
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int i = 0;
        while (i < nums.length) {
            int n = nums[i];
            int j = i + 1;
            while (j < nums.length && nums[j] > n) {
                n = nums[j];
                j++;
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }
    
    @Test
    public void isToeplitzMatrixTest() {
        System.out.println(isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
        }));
        System.out.println(isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2}
        }));
        
        System.out.println(isToeplitzMatrix(new int[][]{
                {11, 74, 0, 93},
                {40, 11, 74, 7}
        }));
    }
    
    /**
     * 766. 托普利茨矩阵
     * <p>
     * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
     *
     * @param matrix 二维矩阵
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int j = 0;
            int ii = i;
            int n = matrix[ii][j];
            while (ii < row && j < col) {
                if (matrix[ii][j] != n) {
                    return false;
                }
                ii++;
                j++;
            }
        }
        for (int j = 0; j < col; j++) {
            int i = 0;
            int jj = j;
            int n = matrix[i][jj];
            while (jj < col && i < row) {
                if (n != matrix[i][jj]) {
                    return false;
                }
                i++;
                jj++;
            }
        }
        return true;
    }
    
    @Test
    public void matrixReshapeTest() {
        int[][] res = matrixReshape(new int[][]{
                {1}, {2}, {3}, {4}
        }, 2, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    
    /**
     * 566. 重塑矩阵
     *
     * @param nums [[1,2], [3,4]]
     * @param r    1
     * @param c    4
     * @return [[1, 2, 3, 4]]
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) {
            return nums;
        }
        int index = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            res[i] = new int[c];
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[index / col][index % col];
                index++;
            }
        }
        return res;
    }
    
    
    @Test
    public void arrayPairSumTest() {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }
    
    /**
     * 561. 数组拆分 I
     * (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大
     *
     * @param nums [1,4,3,2]
     * @return int 4   (1,2) + (3,4) = 1 + 3 = 4
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    
    
    @Test
    public void maxDistToClosestTest() {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
    }
    
    /**
     * 849. 到最近的人的最大距离
     *
     * @param seats [1,0,0,0,1,0,1]
     * @return int
     */
    public int maxDistToClosest(int[] seats) {
        if (seats.length == 1) {
            return 0;
        }
        if (seats.length == 2) {
            return 1;
        }
        int start = 0;
        while (seats[start] == 0) {
            start++;
        }
        int end = seats.length - 1;
        while (seats[end] == 0) {
            end--;
        }
        int max = Math.max(start, (seats.length - 1 - end));
        if (start >= end) {
            return max;
        }
        int i = start + 1;
        while (i < end) {
            int j = i;
            while (j < end && seats[j] == 0) {
                j++;
            }
            int dist = j - i;
            max = Math.max(max, (dist & 1) == 0 ? dist >> 1 : (dist + 1) >> 1);
            i = j + 1;
        }
        return max;
    }
    
    /**
     * 551. Student Attendance Record I
     * 字符串s仅包含三个字符,分表代表学生的出勤情况
     * 'A' : Absent.
     * 'L' : Late.
     * 'P' : Present.
     * 如果一个学生出勤没有超过一次的Absent,或者超过连续两次的Late,则可以获得奖励
     *
     * @param s String
     * @return true/false
     */
    public boolean checkRecord(String s) {
        int a = 0;
        int[] l = new int[]{-2, -2};
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'A':
                    a++;
                    if (a == 2) return false;
                    break;
                case 'L':
                    //连续三个
                    if (l[0] + 1 == l[1] && l[1] + 1 == i) {
                        return false;
                    } else if (l[0] + 1 == i) {
                        l[1] = i;
                    } else {
                        l[0] = i;
                    }
                    break;
            }
        }
        return true;
    }
    
    @Test
    public void reverseWordsTest() {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    
    /**
     * 557. Reverse Words in a String III
     * 翻转字符串句子中的单词
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     *
     * @param s String
     * @return String
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = 0;
        int j = i;
        while (j < len) {
            while (j < len && s.charAt(j) != ' ') {
                j++;
            }
            for (int tmp = j - 1; tmp >= i; tmp--) {
                sb.append(s.charAt(tmp));
            }
            if (j >= len) break;
            sb.append(s.charAt(j));
            i = j + 1;
            j = i;
        }
        return sb.toString();
    }
    
    /**
     * 189. Rotate Array
     * 将数组右侧元素,依次旋转到头部,移动k步
     * input : [1,2,3,4,5,6,7] 3 output : [5,6,7,1,2,3,4]
     *
     * @param nums int[]
     * @param k    int
     */
    public void rotate(int[] nums, int k) {
        //整体翻转,再对前后两部分翻转
        int len = nums.length;
        if (k <= 0) return;
        if (k > len) {
            k = k % len;
        }
        reverseArray(nums, 0, len - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, len - 1);
        System.out.println(Arrays.toString(nums));
    }
    
    private void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
    
    /**
     * 543. Diameter of Binary Tree
     * 求二叉树直径,任意两个节点之间的路径长度,不限于经过根节点
     * 叶子节点之间的最长距离
     *
     * @param root TreeNode
     * @return int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //每个节点左右子树的高度和
        return diameterOfBinaryTree(root, 0);
    }
    
    private int diameterOfBinaryTree(TreeNode root, int max) {
        if (root == null) return max;
        int left = subTreeDepth(root.left);
        int right = subTreeDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(diameterOfBinaryTree(root.left, max),
                diameterOfBinaryTree(root.right, max));
    }
    
    private int subTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = subTreeDepth(root.left);
        int right = subTreeDepth(root.right);
        return 1 + Math.max(left, right);
    }
    
    /**
     * 541. Reverse String II
     * 从头开始每隔2k个字符,翻转k个字符
     * Input: s = "abcdefg", k = 2  Output: "bacdfeg"
     * 字符串只包含小写英文字母
     * 字符串长度和k在[1, 10000]之间
     *
     * @param s String
     * @param k int
     * @return String
     */
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int i = Math.min(k - 1, len - 1);
        int pre = 0;
        while (true) {
            int tmp = i;
            int n = 0;
            while (tmp >= pre && n < k) {
                sb.append(s.charAt(tmp));
                tmp--;
                n++;
            }
            tmp = i + 1;
            n = 0;
            while (tmp < len - 1 && n < k) {
                sb.append(s.charAt(tmp));
                n++;
                tmp++;
            }
            if (tmp >= len) {
                break;
            }
            pre = tmp;
            i = Math.min(tmp + k - 1, len - 1);
        }
        return sb.toString();
    }
    
    /**
     * 458. Poor Pigs
     * 在规定测试时间内找出毒药,最少用多少头猪
     *
     * @param buckets       int 桶的个数,只有一个是毒药,其他是水
     * @param minutesToDie  int 毒药发作时间
     * @param minutesToTest int 测试时间
     * @return int
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        buckets--;
        int base = minutesToTest / minutesToDie + 1;
        int count = 0;
        while (buckets > 0) {
            buckets /= base;
            count++;
        }
        return count;
    }
    
    /**
     * 532. K-diff Pairs in an Array
     * k-diff pair is defined as an integer pair (i, j),
     * where i and j are both numbers in the array and their absolute difference is k.
     * Input: [3, 1, 4, 1, 5], k = 2
     * Output: 2 (1, 3) (3, 5)
     * 先排序,two pointers方法,
     *
     * @param nums int
     * @param k    int
     * @return int k-diff pair的个数,排重后的个数
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        int j = 1;
        int count = 0;
        int pre = Integer.MIN_VALUE; //判断去重
        while (i < len && j < len) {
            int diff = nums[j] - nums[i];
            if (diff == k) {
                if (pre != nums[i]) {
                    pre = nums[i];
                    count++;
                }
                i++;
                j++;
            } else if (diff < k) {
                j++;
            } else if (diff > k) {
                i++;
            }
            if (i >= j) {
                j++;
            }
        }
        return count;
    }
    
    
    /**
     * 437. Path Sum III
     * 二叉树,找出所有和等于给定sum的路径数
     * 路径不需要是从root到叶子节点,其中任意一段即可
     *
     * @param root TreeNode
     * @param sum  int
     * @return int
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }
    
    private int helper(TreeNode root, int curSum, int target, Map<Integer, Integer> preSum) {
        if (root == null) return 0;
        
        curSum += root.val;
        int res = preSum.getOrDefault(curSum - target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        
        res += helper(root.left, curSum, target, preSum) + helper(root.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }
    
    /**
     * 501. Find Mode in Binary Search Tree
     * 二叉搜索树,中有重复的元素,找出重复最多的元素
     * 先中序遍历成升序数组,再求重复最多元素
     *
     * @param root TreeNode
     * @return int[]
     */
    public int[] findMode(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        Map<Integer, Integer> map = new TreeMap<>();
        int dup = 1;
        for (Integer n : nums) {
            if (map.containsKey(n)) {
                int t = map.get(n);
                map.put(n, t + 1);
                dup = Math.max(dup, t + 1);
            } else {
                map.put(n, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == dup) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    /**
     * 530. Minimum Absolute Difference in BST
     * 非负整数,找出最小绝对值差
     * 中序遍历数组是升序的,比较相邻的最小值即可
     *
     * @param root TreeNode
     * @return int
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        System.out.println(list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }
    
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    
    
    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * 将递增数组转换成[平衡二叉搜索树]
     *
     * @param nums int[] 递增数组
     * @return TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);
        return node;
    }
    
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    /**
     * 504. Base 7
     * 返回7进制的字符串表示
     *
     * @param num int
     * @return String
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean positive = num >= 0;
        if (!positive) num = -num;
        int[] arr = new int[]{1, 7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607};
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            int base = arr[i];
            int div = num / base;
            if (!"".equals(res) || div > 0) {
                res += div;
            }
            num = num % base;
        }
        return positive ? res : "-" + res;
        
    }
    
    /**
     * 455. Assign Cookies
     * 数组s与g对比,满足s中数字大于等于g中数字的最多个数
     *
     * @param g int[]
     * @param s int[]
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        List<Integer> list = new ArrayList<>();
        for (int n : s) {
            list.add(n);
        }
        Collections.sort(list);
        
        int content = 0;
        for (int n : g) {
            int index = list.indexOf(n);
            if (index != -1) {
                content++;
                list.remove(index);
            } else {
                boolean get = false;
                for (index = 0; index < list.size(); index++) {
                    if (list.get(index) >= n) {
                        content++;
                        get = true;
                        break;
                    }
                }
                if (get) list.remove(index);
            }
        }
        return content;
    }
    
    
    /**
     * 506. Relative Ranks
     * 根据数字大小输出他们的排名
     * 前三名为 "Gold Medal", "Silver Medal", "Bronze Medal",后续使用排名代替
     *
     * @param nums int[]
     * @return String[]
     */
    public String[] findRelativeRanks(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (int n : nums) {
            map.put(n, null);
        }
        int rank = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.setValue(rank);
            rank++;
        }
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rank = map.get(nums[i]);
            String str;
            switch (rank) {
                case 1:
                    str = "Gold Medal";
                    break;
                case 2:
                    str = "Silver Medal";
                    break;
                case 3:
                    str = "Bronze Medal";
                    break;
                default:
                    str = String.valueOf(rank);
            }
            result[i] = str;
        }
        return result;
    }
    
    /**
     * 520. Detect Capital
     * 字符串全部大写,全部小写,首字母大写
     * a-z 97-122
     * A-Z 65-90
     *
     * @param word String
     * @return boolean
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean type = judgeCase(word.charAt(1));
        boolean same = true;
        for (int i = 2; i < word.length(); i++) {
            boolean t = judgeCase(word.charAt(i));
            if (t != type) {
                same = false;
                break;
            }
        }
        if (!same) return false;
        boolean first = judgeCase(word.charAt(0));
        return !(!first && type);
    }
    
    private boolean judgeCase(char ch) {
        return !(ch >= 'a' && ch <= 'z') && ch >= 'A' && ch <= 'Z';
    }
    
    /**
     * 496. Next Greater Element I
     * findNums,nums数组无重复
     * findNums是nums的子集
     * 找出findNums中每个数字在nums中后面第一个更大的数字,如果没有输出-1
     *
     * @param findNums int[]
     * @param nums     int[]
     * @return int[]
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        //nums中每个数字 : nextGreater
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            int next = n;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > next) {
                    next = nums[j];
                    break;
                }
            }
            map.put(n, next > n ? next : -1);
        }
        len = findNums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
    
    
    /**
     * 500. Keyboard Row
     * 找出输入单词里的字母全部在键盘的同一行
     *
     * @param words string[]
     * @return string[]
     */
    public String[] findWords(String[] words) {
        Map<Character, Integer> keyboard = new HashMap<>();
        keyboard.put('q', 1);
        keyboard.put('Q', 1);
        keyboard.put('w', 1);
        keyboard.put('W', 1);
        keyboard.put('e', 1);
        keyboard.put('E', 1);
        keyboard.put('r', 1);
        keyboard.put('R', 1);
        keyboard.put('t', 1);
        keyboard.put('T', 1);
        keyboard.put('y', 1);
        keyboard.put('Y', 1);
        keyboard.put('u', 1);
        keyboard.put('U', 1);
        keyboard.put('i', 1);
        keyboard.put('I', 1);
        keyboard.put('o', 1);
        keyboard.put('O', 1);
        keyboard.put('p', 1);
        keyboard.put('P', 1);
        
        keyboard.put('a', 2);
        keyboard.put('A', 2);
        keyboard.put('s', 2);
        keyboard.put('S', 2);
        keyboard.put('d', 2);
        keyboard.put('D', 2);
        keyboard.put('f', 2);
        keyboard.put('F', 2);
        keyboard.put('g', 2);
        keyboard.put('G', 2);
        keyboard.put('h', 2);
        keyboard.put('H', 2);
        keyboard.put('j', 2);
        keyboard.put('J', 2);
        keyboard.put('k', 2);
        keyboard.put('K', 2);
        keyboard.put('l', 2);
        keyboard.put('L', 2);
        
        keyboard.put('z', 3);
        keyboard.put('Z', 3);
        keyboard.put('x', 3);
        keyboard.put('X', 3);
        keyboard.put('c', 3);
        keyboard.put('C', 3);
        keyboard.put('v', 3);
        keyboard.put('V', 3);
        keyboard.put('b', 3);
        keyboard.put('B', 3);
        keyboard.put('n', 3);
        keyboard.put('N', 3);
        keyboard.put('m', 3);
        keyboard.put('M', 3);
        
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int i = 0;
            boolean ok = true;
            for (Character ch : word.toCharArray()) {
                if (i == 0) {
                    i = keyboard.get(ch);
                } else {
                    if (i != keyboard.get(ch)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) result.add(word);
        }
        String[] array = new String[result.size()];
        return result.toArray(array);
    }
    
    @Test
    public void minMovesTest() {
        System.out.println(minMoves2(new int[]{1, 1, 2147483647}));
        System.out.println(minMoves2(new int[]{1, 2, 3}));
        System.out.println(minMoves2(new int[]{-100, 0, 100}));
        System.out.println(minMoves2(new int[]{0, 0, 100}));
    }
    
    /**
     * 453. Minimum Moves to Equal Array Elements
     * 移动数组元素,使数组中元素都相等
     * a move is incrementing n - 1 elements by 1
     * 每次使数组中n-1个元素+1,最终使全部元素相等
     * 数组中每个元素与最小值差值 之和
     * 每次n-1个元素加1,最后数组中值全等,补上所有值与最小值差值之和
     *
     * @param nums int[]
     * @return int
     */
    public int minMoves(int[] nums) {
        if (nums.length <= 1) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(n, min);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
    
    public int minMoves2(int[] nums) {
        int min = nums[0];
        int moves = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                moves += (min - nums[i]) * i;
                min = nums[i];
            } else {
                moves += nums[i] - min;
            }
        }
        return moves;
    }
    
    /**
     * 441. Arranging Coins
     * n个硬币,组成楼梯形状 第k层有k个硬币
     * <p>
     * 1+2+3+...+x < n 的最大的x x*(x+1)/2
     *
     * @param n int 非负整数,32位有符号数
     * @return int 返回完整楼梯的行数
     */
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        long x = (long) Math.sqrt(2 * (long) n);
        if (x < 1) return 1;
        while (x * (x + 1) / 2 <= n) {
            x++;
        }
        return (int) (--x);
    }
    
    /**
     * 475. Heaters 加热器
     * 房间和加热器在水平线上,求加热器的最小加热半径,使所有房间都保持温度
     * Input: [1,2,3],[2]  Output: 1
     * Input: [1,2,3,4],[1,4]  Output: 1
     * Binary Search
     * 房间和加热器个数不超过25000,位置不超过10^9
     *
     * @param houses  int[] 正整数
     * @param heaters int[]
     * @return int
     */
    public int findRadius(int[] houses, int[] heaters) {
        //每一个房间找离最近的加热器
        List<Position> list = new ArrayList<>();
        int radius = 0;
        //房间是-1,加热器是1
        for (int house : houses) {
            list.add(new Position(house, -1));
        }
        for (int heater : heaters) {
            list.add(new Position(heater, 1));
        }
        Collections.sort(list, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.getNum() - o2.getNum();
            }
        });
        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Position position = list.get(i);
            int num = position.getNum();
            if (position.getType() == -1) {
                //往前找
                int j = i;
                int tmpL = Integer.MAX_VALUE;
                while (j >= 0 && list.get(j).getType() != 1) j--;
                if (j >= 0) {
                    tmpL = num - list.get(j).getNum();
                }
                //往后找
                j = i;
                int tmpR = Integer.MAX_VALUE;
                while (j < size && list.get(j).getType() != 1) j++;
                if (j < size) {
                    tmpR = list.get(j).getNum() - num;
                }
                int tmp = Math.min(tmpL, tmpR); //前后的最短距离
                if (radius < tmp) radius = tmp;
            }
        }
        return radius;
    }
    
    static class Position {
        private int num;
        private int type; //-1房间,1加热器
        
        public Position(int num, int type) {
            this.num = num;
            this.type = type;
        }
        
        public int getNum() {
            return num;
        }
        
        public void setNum(int num) {
            this.num = num;
        }
        
        public int getType() {
            return type;
        }
        
        public void setType(int type) {
            this.type = type;
        }
        
        @Override
        public String toString() {
            return "Position{" +
                    "num=" + num +
                    ", type=" + type +
                    '}';
        }
    }
    
    
    /**
     * 434. Number of Segments in a String
     * 返回字符串中,段数 空格分割
     *
     * @param s string 不包含不可见字符
     * @return int
     */
    public int countSegments(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        return s.split("\\s+").length;
    }
    
    @Test
    public void repeatedSubstringPatternTest() {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("bb"));
    }
    
    /**
     * 459. Repeated Substring Pattern
     * 判断一个字符串是否是其一个子串的重复
     *
     * @param str String abab 只包含小写字符,长度不超过10000
     * @return boolean true
     */
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() <= 1) return false;
        char first = str.charAt(0);
        if (str.replace(String.valueOf(first), "").equals("")) return true;
        StringBuilder sb = new StringBuilder().append(first);
        int len = str.length();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == first && len % sb.length() == 0) {
                //len % sb.length() == 0 多一层条件判断,过滤不符合条件的,减少replace判断操作
                //去掉这个条件, time limit
                if (str.replace(sb, "").equals("")) {
                    return true;
                }
            }
            sb.append(str.charAt(i));
        }
        return false;
    }
    
    /**
     * 447. Number of Boomerangs
     * 平面中n个点,
     * a "boomerang" is a tuple of points (i, j, k)
     * i到j的距离 = i到k的距离
     * i j k 顺序相关
     * 求每个点到另外点的距离,距离相等的个数n,可组成boomerang的个数为 n*(n-1)
     *
     * @param points int[][] [[0,0],[1,0],[2,0]]
     * @return int 2 [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] p2 = points[j];
                int dis = calDistance(p1, p2);
                Integer v = map.get(dis);
                if (v != null) {
                    map.put(dis, v + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            for (Integer v : map.values()) {
                res += v * (v - 1);
            }
        }
        return res;
    }
    
    private int calDistance(int[] a, int[] b) {
        return (int) (Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
    
    /**
     * 492. Construct the Rectangle
     * 给出面积,设计page web矩形的长宽
     * 面积=给出target area
     * L >= W.
     * L W 的大小尽量接近
     *
     * @param area int 正整数,不大于10,000,000
     * @return int[] 长宽是正整数 [L , W]
     */
    public int[] constructRectangle(int area) {
        int w = 1;
        int l = area;
        int[] res = new int[]{l, w};
        while (w <= l) {
            w++;
            if (area % w == 0) {
                l = area / w;
                if ((l - w) >= 0 && (l - w) < (res[0] - res[1])) {
                    res[0] = l;
                    res[1] = w;
                }
            }
        }
        return res;
    }
    
    /**
     * 463. Island Perimeter 求岛的周长
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * return 16, 两个1相邻,周长=2*4 - 2
     *
     * @param grid int[][]
     * @return int
     */
    public int islandPerimeter(int[][] grid) {
        //一共多少个1,有多少相邻
        int numberOf1 = 0;
        int neighbor = 0;
        int width = grid[0].length;
        int height = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int value = grid[i][j];
                if (value == 1) {
                    numberOf1++;
                    int x = i;
                    int y = j - 1;
                    if (y >= 0 && grid[x][y] == 1) neighbor++;
                    
                    x = i;
                    y = j + 1;
                    if (y < width && grid[x][y] == 1) neighbor++;
                    
                    x = i - 1;
                    y = j;
                    if (x >= 0 && grid[x][y] == 1) neighbor++;
                    
                    x = i + 1;
                    y = j;
                    if (x < height && grid[x][y] == 1) neighbor++;
                }
            }
        }
        return numberOf1 * 4 - neighbor;
    }
    
    static class Point {
        private int x;
        private int y;
        private int v;
        
        public Point(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
        
        public int getV() {
            return v;
        }
        
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", v=" + v +
                    '}';
        }
    }
    
    /**
     * 448. Find All Numbers Disappeared in an Array
     * 数组中某些数字出现两次,或者一次
     * 找出未在数组中出现的全部数字,数组中数字本身也是index
     * Input:
     * [4,3,2,7,8,2,3,1]
     * Output:
     * [5,6]
     *
     * @param nums int[] 1 ≤ a[i] ≤ n (n = size of array)
     * @return list Integer
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int n = nums[i];
            if (n == 0) {
                i++;
            } else {
                while (n != 0) {
                    int j = n - 1;
                    n = nums[j];
                    if (nums[j] == 0) {
                        i++;
                        break;
                    }
                    nums[j] = 0;
                }
            }
        }
        //数组中不为零数字index+1为缺失的数字
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                result.add(j + 1);
            }
        }
        return result;
    }
    
    /**
     * 485. Max Consecutive Ones
     * 给出一个二进制数组,里面是0,1,找出连续1组成的最大数
     * [1,1,0,1,1,1] return 3
     * 数组长度不超过10,000
     *
     * @param nums int[] binary array
     * @return int
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        //遍历一遍,找出最长连续1的个数
        int max = 0;
        int cur = 0;
        for (int n : nums) {
            if (n == 0) {
                max = cur > max ? cur : max;
                cur = 0;
            } else {
                cur++;
            }
        }
        return cur > max ? cur : max;
    }
    
    /**
     * 476. Number Complement
     * 求num的补码,翻转各位上的0和1
     * <p>
     * Note:
     * 1, The given integer is guaranteed to fit within the range of a 32-bit signed integer. 32位有符号数
     * 2, You could assume no leading zero bit in the integer’s binary representation.
     *
     * @param num int
     * @return int
     */
    public int findComplement(int num) {
        byte[] bits = new byte[32];
        int n = 32;
        //转换成二进制表示
        while (n > 0) {
            int i = (num >> (n - 1)) & 1;
            bits[32 - n] = ((byte) (i));
            n--;
        }
        boolean first = false;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (first || bits[i] == 1) {
                first = true;
                byte b = (byte) (bits[i] ^ 1);
                if (b == 1) {
                    res = res | (1 << (31 - i));
                }
            }
        }
        return res;
    }
    
    /**
     * 461. Hamming Distance
     * 计算两个整数的汉明码,各位二进制0,1不同的位数
     * 0 <= x,y < 2^31
     *
     * @param x int 1
     * @param y int 4
     * @return int 2
     */
    public int hammingDistance(int x, int y) {
        return hammingWeight(x ^ y);
    }
    
    private int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }
    
}
