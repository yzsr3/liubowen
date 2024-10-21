
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class L2022212031_17_Test {

    // 创建一个 Solution 实例
    private Solution solution = new Solution();

    // 测试用例：输入长度小于10的DNA序列
    @Test
    public void testShortDnaSequence() {
        String s = "ACGT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertTrue(result.isEmpty()); // 期望结果为空列表
    }

    // 测试用例：输入长度等于10的DNA序列，且没有重复
    @Test
    public void testUniqueDnaSequence() {
        String s = "ACGTACGTACGT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertTrue(result.isEmpty()); // 期望结果为空列表
    }

    // 测试用例：输入包含重复长度为10的DNA序列
    @Test
    public void testRepeatedDnaSequence() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertEquals(2, result.size()); // 期望结果大小为2
        assertTrue(result.contains("AAAAACCCCC")); // 期望包含"AAAAACCCCC"
        assertTrue(result.contains("CCCCCAAAAA")); // 期望包含"CCCCCAAAAA"
    }

    // 测试用例：输入全为相同字符的DNA序列
    @Test
    public void testHomogeneousDnaSequence() {
        String s = "AAAAAAAAAAA";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertEquals(1, result.size()); // 期望结果大小为1
        assertTrue(result.contains("AAAAAAAAAA")); // 期望包含"AAAAAAAAAA"
    }

    // 测试用例：输入包含多种重复长度为10的DNA序列
    @Test
    public void testMultipleRepeatedDnaSequences() {
        String s = "ACGTACGTACGTACGTACGT";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertEquals(2, result.size()); // 期望结果大小为2（ACGTACGTAC 和 CGTACGTACG）
        // 注意：由于题目要求只返回第一次出现的重复序列，因此实际结果可能只包含其中一个
        // 这里我们检查是否包含至少一个预期的重复序列
        assertTrue(result.contains("ACGTACGTAC") || result.contains("CGTACGTACG"));
    }

    // 测试用例：输入为空字符串
    @Test
    public void testEmptyDnaSequence() {
        String s = "";
        List<String> result = solution.findRepeatedDnaSequences(s);
        assertTrue(result.isEmpty()); // 期望结果为空列表
    }
}