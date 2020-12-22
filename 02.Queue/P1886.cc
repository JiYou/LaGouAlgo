// https://www.luogu.com.cn/problem/P1886
// c++11

#include <stdio.h>

constexpr int MOD = 1000008;

// 单调队列的实现类
// 应该把Node更名成monotonous queue
// 由于题目里面最大空间就是1e6
// 所以这里我是直接写死了空间的大小，按理说应该是用vector更加合理
struct Node {
    int q[MOD];
    int head = 0;
    int tail = 0;
    int used = 0;
    // inc = true表示是一个单调递增的队列
    // inc = false表示是一个单调递减的队列
    bool inc = false;

    Node(bool isInc) : inc(isInc) {}

    // 得到最后一个元素所在下标
    int back() const { return (tail - 1 + MOD) % MOD; }

    void push(int val) {
        // 如果是一个单调递减队列
        // 队首元素是一个最大值
        if (!inc) {
            while (used > 0 && q[back()] < val) {
                tail = back();
                used--;
            }
        } else {
            // 如果是一个单调递增队列
            // 队首元素是一个最小值
            while (used > 0 && q[back()] > val) {
                tail = back();
                used--;
            }
        }
        // 入队
        q[tail] = val;
        used++;
        tail = (tail + 1) % MOD;
    }

    void pop(int val) {
        // 出队函数都是一样的
        if (used > 0 && q[head] == val) {
            head = (head + 1) % MOD;
            used--;
        }
    }

    // 得到队首元素
    int front() { return q[head]; }
};

// 队首元素是最大值的队列
struct Node large {
    // 当然必须要是单调递减inc = false
    false
};

// 队首元素是最小值的队列
struct Node small {
    // 当然必须要是单调递增的inc = true
    true
};

// 元素个数
int N;

// 滑动窗口个数
int k;

// 输入原始数组
int A[MOD];

void find_min() {
    // 注意清理旧有的队列的状态
    small.head = small.tail = small.used = 0;

    // 开始找到滑动窗口的最小值
    for (int i = 0; i < N; i++) {
        small.push(A[i]);
        if (i < k - 1) {
            continue;
        }
        printf("%d ", small.front());
        small.pop(A[i - k + 1]);
    }
    printf("\n");
}

void find_max() {
    // 注意清理旧有的队列的状态
    large.head = large.tail = large.used = 0;

    // 开始找到滑动窗口的最小值
    for (int i = 0; i < N; i++) {
        large.push(A[i]);
        if (i < k - 1) {
            continue;
        }
        printf("%d ", large.front());
        large.pop(A[i - k + 1]);
    }
    printf("\n");
}

int main(void) {
    while (scanf("%d%d", &N, &k) != EOF) {
        for (int i = 0; i < N; i++) {
            scanf("%d", A + i);
        }

        find_min();
        find_max();
    }
    return 0;
}
