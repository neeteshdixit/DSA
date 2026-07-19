const FREQ_MAP_CODE = String.raw`Map<Character, Integer> freq = new HashMap<>();
for (char ch : s.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}`;

const PREFIX_SUM_CODE = String.raw`Map<Integer, Integer> freq = new HashMap<>();
freq.put(0, 1);

int sum = 0;
int count = 0;
for (int num : nums) {
    sum += num;
    count += freq.getOrDefault(sum - k, 0);
    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
}`;

const TWO_SUM_CODE = String.raw`Map<Integer, Integer> seen = new HashMap<>();
for (int i = 0; i < nums.length; i++) {
    int need = target - nums[i];
    if (seen.containsKey(need)) {
        return new int[] { seen.get(need), i };
    }
    seen.put(nums[i], i);
}
return new int[0];`;

const SLIDING_WINDOW_CODE = String.raw`Map<Character, Integer> freq = new HashMap<>();
int left = 0;
int best = 0;

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);

    while (/* window invalid */ false) {
        char remove = s.charAt(left++);
        int next = freq.get(remove) - 1;
        if (next == 0) freq.remove(remove);
        else freq.put(remove, next);
    }
    best = Math.max(best, right - left + 1);
}`;

const FAST_SLOW_POINTER_CODE = String.raw`ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    if (slow == fast) {
        return true;
    }
}
return false;`;

const DUMMY_NODE_CODE = String.raw`ListNode dummy = new ListNode(0);
ListNode tail = dummy;

while (l1 != null && l2 != null) {
    if (l1.val < l2.val) {
        tail.next = l1;
        l1 = l1.next;
    } else {
        tail.next = l2;
        l2 = l2.next;
    }
    tail = tail.next;
}
tail.next = (l1 != null) ? l1 : l2;
return dummy.next;`;

const REVERSE_LIST_CODE = String.raw`ListNode prev = null;
ListNode curr = head;

while (curr != null) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;`;

const BALANCED_PARENTHESES_CODE = String.raw`Deque<Character> stack = new ArrayDeque<>();

for (char ch : s.toCharArray()) {
    if (ch == '(' || ch == '[' || ch == '{') {
        stack.push(ch);
    } else {
        if (stack.isEmpty()) return false;
        char open = stack.pop();
        if ((ch == ')' && open != '(') ||
            (ch == ']' && open != '[') ||
            (ch == '}' && open != '{')) {
            return false;
        }
    }
}
return stack.isEmpty();`;

const EXPRESSION_EVAL_CODE = String.raw`Deque<Integer> values = new ArrayDeque<>();
Deque<Character> ops = new ArrayDeque<>();

for (int i = 0; i < expr.length(); i++) {
    char ch = expr.charAt(i);
    if (Character.isDigit(ch)) {
        int num = 0;
        while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
            num = num * 10 + (expr.charAt(i) - '0');
            i++;
        }
        i--;
        values.push(num);
    } else if (ch == '(') {
        ops.push(ch);
    } else if (ch == ')') {
        while (!ops.isEmpty() && ops.peek() != '(') {
            apply(values, ops.pop());
        }
        ops.pop();
    } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
            apply(values, ops.pop());
        }
        ops.push(ch);
    }
}
while (!ops.isEmpty()) apply(values, ops.pop());
return values.pop();`;

const MONOTONIC_STACK_CODE = String.raw`Deque<Integer> stack = new ArrayDeque<>();

for (int i = 0; i < nums.length; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        int idx = stack.pop();
        answer[idx] = nums[i];
    }
    stack.push(i);
}
while (!stack.isEmpty()) answer[stack.pop()] = -1;`;

const MONOTONIC_QUEUE_CODE = String.raw`Deque<Integer> dq = new ArrayDeque<>();

for (int i = 0; i < nums.length; i++) {
    while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
    }
    while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
        dq.pollLast();
    }
    dq.offerLast(i);
    if (i >= k - 1) {
        result[i - k + 1] = nums[dq.peekFirst()];
    }
}`;

const BFS_QUEUE_CODE = String.raw`Queue<TreeNode> queue = new ArrayDeque<>();
queue.offer(root);

while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}`;

const TOPO_QUEUE_CODE = String.raw`Queue<Integer> queue = new ArrayDeque<>();
for (int i = 0; i < n; i++) {
    if (indegree[i] == 0) queue.offer(i);
}

List<Integer> order = new ArrayList<>();
while (!queue.isEmpty()) {
    int node = queue.poll();
    order.add(node);
    for (int next : graph.get(node)) {
        if (--indegree[next] == 0) queue.offer(next);
    }
}`;

const CIRCULAR_QUEUE_CODE = String.raw`class MyCircularQueue {
    private final int[] data;
    private int front = 0, rear = 0, size = 0;

    public MyCircularQueue(int k) {
        data = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % data.length;
        size--;
        return true;
    }
}`;

const MIN_STACK_CODE = String.raw`class MinStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> mins = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        if (mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(mins.peek())) {
            mins.pop();
        }
    }

    public int getMin() {
        return mins.peek();
    }
}`;

const STACK_SIMULATION_CODE = String.raw`Deque<Character> stack = new ArrayDeque<>();

for (char ch : s.toCharArray()) {
    if (!stack.isEmpty() && stack.peek() == ch) {
        stack.pop();
    } else {
        stack.push(ch);
    }
}

StringBuilder result = new StringBuilder();
while (!stack.isEmpty()) {
    result.append(stack.pop());
}
return result.reverse().toString();`;

const MAX_STACK_CODE = String.raw`class MaxStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> maxes = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        if (maxes.isEmpty() || val >= maxes.peek()) {
            maxes.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(maxes.peek())) {
            maxes.pop();
        }
    }

    public int getMax() {
        return maxes.peek();
    }
}`;

const PRIORITY_QUEUE_CODE = String.raw`PriorityQueue<Task> pq = new PriorityQueue<>(
    (a, b) -> a.priority != b.priority ? Integer.compare(a.priority, b.priority) : Integer.compare(a.time, b.time)
);

pq.offer(task);`;

const ANAGRAM_BUCKET_CODE = String.raw`Map<String, List<String>> groups = new HashMap<>();

for (String word : words) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    String key = new String(chars);
    groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
}`;

const LONGEST_CONSECUTIVE_CODE = String.raw`Set<Integer> set = new HashSet<>();
for (int num : nums) set.add(num);

int best = 0;
for (int num : set) {
    if (!set.contains(num - 1)) {
        int len = 1;
        while (set.contains(num + len)) len++;
        best = Math.max(best, len);
}
}`;

const SET_LOOKUP_CODE = String.raw`Set<Integer> seen = new HashSet<>();
for (int num : nums) {
    if (seen.contains(num)) {
        return true;
    }
    seen.add(num);
}
return false;`;

const INDEX_MAP_CODE = String.raw`Map<Integer, Integer> firstSeen = new HashMap<>();

for (int i = 0; i < nums.length; i++) {
    firstSeen.putIfAbsent(nums[i], i);
}`;

const MERGE_LISTS_CODE = String.raw`ListNode dummy = new ListNode(0);
ListNode tail = dummy;

while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) {
        tail.next = l1;
        l1 = l1.next;
    } else {
        tail.next = l2;
        l2 = l2.next;
    }
    tail = tail.next;
}
tail.next = (l1 != null) ? l1 : l2;
return dummy.next;`;

const CYCLE_DETECTION_CODE = FAST_SLOW_POINTER_CODE;

export const TEMPLATES = [
  {
    id: 'frequency-map',
    title: 'Frequency Map',
    category: 'Hashing',
    summary: 'Count occurrences in one pass and answer lookup questions directly from the map.',
    whenToUse: 'Use when the prompt asks for counts, duplicates, anagrams, or uniqueness checks.',
    code: FREQ_MAP_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['frequency-count', 'duplicate-detection', 'first-unique-character', 'majority-element-map'],
    tips: ['Normalize case and whitespace before counting if the prompt allows it.', 'Prefer getOrDefault for compact updates.'],
    tags: ['hashmap', 'counting', 'lookup'],
  },
  {
    id: 'prefix-sum',
    title: 'Prefix Sum + HashMap',
    category: 'Arrays / Hashing',
    summary: 'Transform subarray-sum questions into prefix-difference lookups.',
    whenToUse: 'Use when a question asks for subarrays, ranges, or count of ways to reach a sum.',
    code: PREFIX_SUM_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['prefix-sum-map', 'sliding-window-hashmap'],
    tips: ['Initialize the zero prefix with frequency 1.', 'Store running sum, not the entire prefix array, when memory matters.'],
    tags: ['prefix', 'subarray', 'sum'],
  },
  {
    id: 'two-sum',
    title: 'Two Sum Lookup',
    category: 'Hashing / Arrays',
    summary: 'Check complement availability in O(1) average time.',
    whenToUse: 'Use when the task asks for pair sum, complement lookup, or one-pass matching.',
    code: TWO_SUM_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['pair-sum-two-sum', 'duplicate-detection'],
    tips: ['Check the complement before inserting the current value.', 'Return indices or values according to the problem statement.'],
    tags: ['pair-sum', 'complement', 'lookup'],
  },
  {
    id: 'sliding-window',
    title: 'Sliding Window + HashMap',
    category: 'Strings / Arrays',
    summary: 'Keep a frequency map for the current window and shrink from the left when invalid.',
    whenToUse: 'Use when the question mentions subarray, substring, longest/shortest window, or at-most constraints.',
    code: SLIDING_WINDOW_CODE,
    complexity: 'Time O(n), Space O(k)',
    relatedPatterns: ['sliding-window-hashmap', 'frequency-count'],
    tips: ['Always define the window invariant first.', 'Decide whether the window is fixed or variable before coding.'],
    tags: ['window', 'substring', 'subarray'],
  },
  {
    id: 'fast-slow-pointer',
    title: 'Fast Slow Pointer',
    category: 'Linked List',
    summary: 'Use two speeds to detect cycles, find the middle, or split the list.',
    whenToUse: 'Use when a list structure may contain a cycle or when the middle node is required.',
    code: FAST_SLOW_POINTER_CODE,
    complexity: 'Time O(n), Space O(1)',
    relatedPatterns: ['fast-slow-pointer', 'cycle-detection'],
    tips: ['Move the fast pointer first in your head before coding.', 'Reset one pointer to head for cycle-entry problems.'],
    tags: ['linked-list', 'cycle', 'middle'],
  },
  {
    id: 'dummy-node',
    title: 'Dummy Node Merge',
    category: 'Linked List',
    summary: 'A sentinel node makes insertion and merge logic cleaner and avoids special casing the head.',
    whenToUse: 'Use when merging, deleting, or building a linked list result node by node.',
    code: DUMMY_NODE_CODE,
    complexity: 'Time O(n + m), Space O(1)',
    relatedPatterns: ['dummy-node', 'merge-two-sorted-lists', 'remove-nth-node'],
    tips: ['Keep a tail pointer that always points to the last constructed node.', 'Return dummy.next, not dummy.'],
    tags: ['dummy', 'merge', 'sentinel'],
  },
  {
    id: 'reverse-linked-list',
    title: 'Reverse Linked List',
    category: 'Linked List',
    summary: 'Reverse pointer directions one node at a time using prev, curr, and next.',
    whenToUse: 'Use when the problem asks to reverse a list, a sublist, or to reorder nodes from the end.',
    code: REVERSE_LIST_CODE,
    complexity: 'Time O(n), Space O(1)',
    relatedPatterns: ['reverse-linked-list', 'reverse-between', 'reverse-k-group'],
    tips: ['Store next before rewiring curr.next.', 'Think of the list as a chain being flipped node by node.'],
    tags: ['reverse', 'pointer-manipulation'],
  },
  {
    id: 'balanced-parentheses',
    title: 'Balanced Parentheses',
    category: 'Stack',
    summary: 'Push opening brackets and validate each closing bracket against the stack top.',
    whenToUse: 'Use when nested delimiters, syntax validation, or expression structure appears.',
    code: BALANCED_PARENTHESES_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['balanced-parentheses', 'expression-evaluation'],
    tips: ['Reject a closing bracket immediately if the stack is empty.', 'Match bracket types explicitly, not just stack size.'],
    tags: ['stack', 'parentheses', 'validation'],
  },
  {
    id: 'expression-evaluation',
    title: 'Expression Evaluation',
    category: 'Stack',
    summary: 'Use operator and value stacks to parse infix expressions with precedence.',
    whenToUse: 'Use when the task asks to evaluate or convert prefix, infix, or postfix notation.',
    code: EXPRESSION_EVAL_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['expression-evaluation', 'balanced-parentheses'],
    tips: ['Define precedence in a helper function.', 'Handle multi-digit numbers and whitespace carefully.'],
    tags: ['stack', 'parser', 'precedence'],
  },
  {
    id: 'monotonic-stack',
    title: 'Monotonic Stack',
    category: 'Stack',
    summary: 'Maintain a stack that is always increasing or decreasing so you can answer neighbor queries fast.',
    whenToUse: 'Use for next/previous greater or smaller element questions and histogram-like boundary problems.',
    code: MONOTONIC_STACK_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['monotonic-stack', 'next-greater-element', 'largest-rectangle'],
    tips: ['Store indices, not values, when you need positions later.', 'Pop while the invariant is broken.'],
    tags: ['stack', 'boundary', 'span'],
  },
  {
    id: 'monotonic-queue',
    title: 'Monotonic Queue',
    category: 'Queue',
    summary: 'Keep candidate indices in a deque so the front always gives the optimum for the current window.',
    whenToUse: 'Use for sliding window maximum/minimum and other windowed best-value problems.',
    code: MONOTONIC_QUEUE_CODE,
    complexity: 'Time O(n), Space O(k)',
    relatedPatterns: ['monotonic-queue', 'sliding-window-maximum'],
    tips: ['Evict expired indices from the front first.', 'Remove smaller candidates from the back before pushing the new index.'],
    tags: ['deque', 'window', 'maximum'],
  },
  {
    id: 'bfs-queue',
    title: 'BFS Queue',
    category: 'Queue',
    summary: 'A queue naturally explores the next frontier level by level.',
    whenToUse: 'Use for tree level order traversal, graph BFS, and multi-source spreading problems.',
    code: BFS_QUEUE_CODE,
    complexity: 'Time O(V + E), Space O(V)',
    relatedPatterns: ['bfs-queue', 'level-order-traversal', 'multi-source-bfs'],
    tips: ['Take queue size at the start of the level.', 'Mark visited before enqueueing to avoid duplicates.'],
    tags: ['bfs', 'tree', 'graph'],
  },
  {
    id: 'topological-queue',
    title: 'Topological Sort Queue',
    category: 'Queue',
    summary: 'Kahn’s algorithm uses indegrees and a queue of ready nodes.',
    whenToUse: 'Use when the graph is directed and you need a valid processing order or cycle check.',
    code: TOPO_QUEUE_CODE,
    complexity: 'Time O(V + E), Space O(V)',
    relatedPatterns: ['topological-queue', 'priority-queue-scheduling'],
    tips: ['Decrement indegree carefully for every outgoing edge.', 'If processed node count is smaller than V, a cycle exists.'],
    tags: ['graph', 'order', 'indegree'],
  },
  {
    id: 'circular-queue',
    title: 'Circular Queue',
    category: 'Queue',
    summary: 'Wrap array indices with modulo arithmetic to reuse fixed capacity efficiently.',
    whenToUse: 'Use when you need constant-time enqueue/dequeue with limited memory and predictable capacity.',
    code: CIRCULAR_QUEUE_CODE,
    complexity: 'Time O(1) per operation, Space O(k)',
    relatedPatterns: ['circular-queue'],
    tips: ['Track size separately instead of comparing front and rear only.', 'Modulo arithmetic avoids shifting elements.'],
    tags: ['queue', 'buffer', 'array'],
  },
  {
    id: 'min-stack',
    title: 'Min Stack',
    category: 'Stack',
    summary: 'Track the current minimum alongside the main stack so queries stay O(1).',
    whenToUse: 'Use when the stack must answer min or max queries after push and pop operations.',
    code: MIN_STACK_CODE,
    complexity: 'Time O(1) per operation, Space O(n)',
    relatedPatterns: ['min-stack', 'stack-simulation'],
    tips: ['Store only when the min changes or duplicate the min on every push.', 'Mirror the stack size if you need a fully aligned min array.'],
    tags: ['stack', 'minimum', 'query'],
  },
  {
    id: 'stack-simulation',
    title: 'Stack Simulation',
    category: 'Stack',
    summary: 'Treat the stack as a simulation layer for canceling, compressing, or reconstructing sequences.',
    whenToUse: 'Use when adjacent elements can annihilate each other or when the output must be built in reverse order.',
    code: STACK_SIMULATION_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['remove-adjacent-duplicates', 'decode-string'],
    tips: ['Use the stack to remember unresolved characters or tokens.', 'Sometimes a StringBuilder stack is enough; you do not always need nodes.'],
    tags: ['stack', 'simulation', 'compression'],
  },
  {
    id: 'max-stack',
    title: 'Max Stack Concept',
    category: 'Stack',
    summary: 'Mirror the min-stack idea to answer maximum queries in constant time.',
    whenToUse: 'Use when the stack must support getMax or a top-k style extreme query after updates.',
    code: MAX_STACK_CODE,
    complexity: 'Time O(1) per operation, Space O(n)',
    relatedPatterns: ['max-stack', 'priority-queue-scheduling'],
    tips: ['Duplicate the current max whenever it stays the same.', 'If you need popMax, a secondary structure or linked list may be required.'],
    tags: ['stack', 'maximum', 'query'],
  },
  {
    id: 'priority-queue-scheduling',
    title: 'Priority Queue Scheduling',
    category: 'Queue',
    summary: 'A priority queue chooses the next best job by priority instead of arrival time.',
    whenToUse: 'Use for task scheduling, CPU scheduling, k-th selection, and best-first processing.',
    code: PRIORITY_QUEUE_CODE,
    complexity: 'Time O(log n) per push/pop, Space O(n)',
    relatedPatterns: ['priority-queue-scheduling'],
    tips: ['Define the comparator from highest priority to lowest priority clearly.', 'Break ties using time or insertion order when needed.'],
    tags: ['heap', 'scheduling', 'priority'],
  },
  {
    id: 'group-anagrams',
    title: 'Group Anagrams',
    category: 'Hashing',
    summary: 'Bucket words by a canonical key so anagrams land in the same group.',
    whenToUse: 'Use when words should be grouped by rearranged character identity.',
    code: ANAGRAM_BUCKET_CODE,
    complexity: 'Time O(n * k log k), Space O(n * k)',
    relatedPatterns: ['group-anagrams', 'frequency-count'],
    tips: ['Sort characters for the simple canonical key, or use 26-count signatures for lower constant factors.', 'Keep original words in the value list.'],
    tags: ['anagram', 'bucket', 'strings'],
  },
  {
    id: 'longest-consecutive',
    title: 'Longest Consecutive Sequence',
    category: 'Hashing',
    summary: 'Store numbers in a set and start only from sequence beginnings.',
    whenToUse: 'Use when the longest streak of consecutive integers is requested.',
    code: LONGEST_CONSECUTIVE_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['longest-consecutive-sequence'],
    tips: ['Only expand from numbers that have no predecessor.', 'A Set removes duplicates automatically.'],
    tags: ['set', 'sequence', 'streak'],
  },
  {
    id: 'set-lookup',
    title: 'Set Membership Lookup',
    category: 'Hashing',
    summary: 'Use a HashSet to test membership, detect duplicates, and prune repeated work.',
    whenToUse: 'Use when you only care about existence, not counts or order.',
    code: SET_LOOKUP_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['duplicate-detection', 'longest-consecutive'],
    tips: ['A set is often the simplest answer to duplicate detection.', 'For ordered or counted information, switch to a map instead.'],
    tags: ['hashset', 'membership', 'dedup'],
  },
  {
    id: 'index-mapping',
    title: 'Index Mapping',
    category: 'Arrays / Hashing',
    summary: 'Remember first or last seen positions so later logic can jump directly to the right place.',
    whenToUse: 'Use when a prompt asks for positions, earliest occurrence, or a coordinate-style mapping.',
    code: INDEX_MAP_CODE,
    complexity: 'Time O(n), Space O(n)',
    relatedPatterns: ['index-mapping', 'first-unique-character'],
    tips: ['putIfAbsent is often cleaner than a manual containsKey guard.', 'Track both index and value if the prompt needs reconstruction.'],
    tags: ['index', 'map', 'position'],
  },
  {
    id: 'merge-two-sorted-lists',
    title: 'Merge Two Sorted Lists',
    category: 'Linked List',
    summary: 'Walk both lists together and attach the smaller node each time.',
    whenToUse: 'Use when two sorted linked lists must be combined without extra sorting.',
    code: MERGE_LISTS_CODE,
    complexity: 'Time O(n + m), Space O(1)',
    relatedPatterns: ['merge-two-sorted-lists', 'dummy-node'],
    tips: ['Advance only the list that contributed the chosen node.', 'Finish by connecting the remaining non-empty list.'],
    tags: ['merge', 'sorted', 'list'],
  },
  {
    id: 'cycle-detection',
    title: 'Cycle Detection',
    category: 'Linked List',
    summary: 'The fast pointer laps the slow pointer if and only if a cycle exists.',
    whenToUse: 'Use when you need to detect a cycle or find the cycle entry.',
    code: CYCLE_DETECTION_CODE,
    complexity: 'Time O(n), Space O(1)',
    relatedPatterns: ['cycle-detection', 'fast-slow-pointer'],
    tips: ['A meeting point does not necessarily mean the cycle entry.', 'Reset one pointer to head for entry-node problems.'],
    tags: ['cycle', 'tortoise', 'hare'],
  },
  {
    id: 'blocking-queue',
    title: 'Blocking Queue Concept',
    category: 'Concurrency',
    summary: 'Producer threads wait when the queue is full, and consumer threads wait when it is empty.',
    whenToUse: 'Use to understand async pipelines, worker pools, and back-pressure in concurrent systems.',
    code: String.raw`BlockingQueue<Task> queue = new ArrayBlockingQueue<>(capacity);

queue.put(task);   // waits if full
Task task = queue.take(); // waits if empty`,
    complexity: 'Conceptual O(1) operations with blocking semantics',
    relatedPatterns: ['producer-consumer', 'priority-queue-scheduling'],
    tips: ['Blocking queues are about coordination, not just storage.', 'Use them when producer speed and consumer speed differ.'],
    tags: ['concurrency', 'producer-consumer', 'blocking'],
  },
];

export const TEMPLATE_MAP = new Map(TEMPLATES.map((template) => [template.id, template]));

export function getTemplateById(id) {
  return TEMPLATE_MAP.get(id) || null;
}
