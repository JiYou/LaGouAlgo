/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 *
 * https://leetcode-cn.com/problems/design-circular-queue/description/
 *
 * algorithms
 * Medium (42.07%)
 * Likes:    155
 * Dislikes: 0
 * Total Accepted:    43.6K
 * Total Submissions: 103.7K
 * Testcase Example:  '["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]\n' +
  '[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于
 * FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 
 * 
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 
 * 你的实现应该支持如下操作：
 * 
 * 
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 * 
 * 
 */

// @lc code=start
class MyCircularQueue {
    // 队列的头部元素所在位置
    private int front = 0;
    // 队列的尾巴
    // 注意我们采用的是前开后闭原则
    // [front, rear)
    private int rear = 0;
    private int[] a = null;
    private int capacity = 0;

    public MyCircularQueue(int k) {
        // 初始化队列，注意此时队列中元素个数为
        // k + 1
        capacity = k + 1;
        a = new int[k + 1];
    }

    public boolean enQueue(int value) {
        // 如果已经满了，无法入队
        if (isFull()) {
            return false;
        }
        // 把元素放到rear位置
        a[rear] = value;
        // rear向后移动
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        // 如果为空，无法出队
        if (isEmpty()) {
            return false;
        }
        // 出队之后，front要向前移
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        // 如果能取出第一个元素，取a[front];
        return isEmpty() ? -1 : a[front];
    }

    public int Rear() {
        // 由于我们使用的是前开后闭原则
        // [front, rear)
        // 所以在取最后一个元素时，应该是
        // (rear - 1 + capacity) % capacity;
        int tail = (rear - 1 + capacity) % capacity;
        return isEmpty() ? -1 : a[tail];
    }

    public boolean isEmpty() {
        // 队列是否为空
        return front == rear;
    }

    public boolean isFull() {
        // rear与front之间至少有一个空格
        // 当rear指向这个最后的一个空格时，
        // 队列就已经放满了!
        return (rear + 1) % capacity == front;
    }
}

// @lc code=end
