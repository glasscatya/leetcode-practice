/*
 * @lc app=leetcode.cn id=232 lang=c
 *
 * [232] 用栈实现队列
 */

// @lc code=start



typedef struct {
    int stackInTop, stackOutTop;
    int stackIn[101], stackOut[101];

} MyQueue;


MyQueue* myQueueCreate() {
    MyQueue* queue = (MyQueue*)malloc(sizeof(MyQueue));
    queue->stackInTop = 0;
    queue->stackOutTop = 0;
    return queue;
}

//向queue中添加数据
void myQueuePush(MyQueue* obj, int x) {
    obj->stackIn[++(obj->stackInTop)] = x;
}

//取出queue队首的数据
int myQueuePop(MyQueue* obj) {
    int stackInTop = obj->stackInTop;
    int stackOutTop = obj->stackOutTop;
    int top;
    //如果stackOut栈中没有数据 则去把stackIn中的数据倒序转移到stackOut中
    //我这种实现中，始终空出0号空间 作为是否为空的判断
    if(stackOutTop == 0) {
        while(stackInTop != 0) {
            //stackout的最底部放置stackin的最顶部内容
            obj->stackOut[++stackOutTop] = obj->stackIn[stackInTop--];
        }
        //重新校准TOP 以更新后为准
        obj->stackInTop = stackInTop;
        obj->stackOutTop = stackOutTop;
    }
    
    top = obj->stackOut[stackOutTop--];
    obj->stackOutTop = stackOutTop;

    return top;
}

int myQueuePeek(MyQueue* obj) {
    // int top;
    // top = myQueuePop(obj);
    // myQueuePush(obj, top);
    // return top;
    int top;
    if(obj->stackOutTop != 0) {
        top = obj->stackOut[obj->stackOutTop]; 
    } else {
        top = obj->stackIn[obj->stackInTop];
    }
    return top;
}

bool myQueueEmpty(MyQueue* obj) {
    return obj->stackInTop == 0 && obj->stackOutTop == 0;
}

void myQueueFree(MyQueue* obj) {
    obj->stackInTop = 0;
    obj->stackOutTop =0;
}

/**
 * Your MyQueue struct will be instantiated and called as such:
 * MyQueue* obj = myQueueCreate();
 * myQueuePush(obj, x);
 
 * int param_2 = myQueuePop(obj);
 
 * int param_3 = myQueuePeek(obj);
 
 * bool param_4 = myQueueEmpty(obj);
 
 * myQueueFree(obj);
*/
// @lc code=end

