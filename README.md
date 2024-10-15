**Студент:** Бабушкин Александр Михайлович  
**ИСУ:** 367845  
**Группа:** P3321  
**Университет:** НИУ ИТМО  
**Факультет:** ПИиКТ  
**Курс:** 3-й курс  

---

# Отчет по решению задач 5 и 26 с Project Euler

В этом проекте представлено несколько решений для задач с сайта Project Euler. Решения реализованы на языке Clojure и включают разные подходы для решения задачи по нахождению наименьшего кратного числа. Ниже приводится анализ каждого решения.

## Решения для Задачи 5

Задача 5 заключается в нахождении наименьшего числа, которое делится на все числа от 1 до 20. Приведено несколько подходов к решению задачи с использованием рекурсии, хвостовой рекурсии, модульности и других методов.

### 1. Хвостовая рекурсия: `Task5TailRec`
Этот модуль использует хвостовую рекурсию для нахождения наименьшего кратного числа. Основная функция:
```clojure
(defn lcm-tail [nums]
  (let [lcm-helper (fn lcm-helper [acc nums]
                     (if (empty? nums)
                       acc
                       (recur (lcm acc (first nums)) (rest nums))))]
    (lcm-helper 1 nums)))
```
Процесс делится на части с помощью функции `loop`, которая эффективно ищет наименьшее кратное чисел от 1 до `n`, избегая переполнения стека.

[Решение](src/tasks/Task5TailRec.clj)

### 2. Рекурсия: `Task5Rec`
Это решение использует простую рекурсию для вычисления наименьшего кратного числа:
```clojure
(defn lcm-recur [nums]
  (if (= (count (seq nums)) 1)
    (first nums)
    (lcm (first nums) (lcm-recur (rest nums)))))
```
Здесь каждая итерация проверяет делимость текущего числа и возвращает наименьшее кратное.

[Решение](src/tasks/Task5Rec.clj)

### 3. Модульное решение: `Task5Module`
Модульное решение использует функции высшего порядка для модульности и фильтрации:
```clojure
(defn lcm-module [n]
  (-> (generate n)
      (filter-lcm)))
```
Это решение более читабельно за счёт использования композиции функций и подходит для функционального стиля программирования.

[Решение](src/tasks/Task5Module.clj)

### 4. Использование `map`: `Task5Map`
Этот модуль использует функцию `map`, чтобы применить умножение ко всем числам в диапазоне от 1 до `n`:
```clojure
(defn lcm-map [n]
  (reduce lcm 1 (map identity (range 1 (inc n)))))
```
Решение лаконично и эффективно для обработки последовательностей с минимальным количеством кода.

[Решение](src/tasks/Task5Map.clj)

### 5. `loop` решение: `Task5Loop`
Решение с использованием цикла `loop` аналогично хвостовой рекурсии:
```clojure
(defn lcm-loop [n]
  (loop [acc 1 nums (range 1 (inc n))]
    (if (empty? nums)
      acc
      (recur (lcm acc (first nums)) (rest nums)))))
```
Цикл позволяет избежать необходимости рекурсивного вызова, тем самым оптимизируя использование ресурсов.

[Решение](src/tasks/Task5Loop.clj)

### 6. Бесконечная последовательность: `Task5Inf`
В этом решении создаётся бесконечная последовательность чисел:
```clojure
(defn lcm-inf [n]
  (let [nums (take n (iterate inc 1))]
    (reduce lcm 1 nums)))

```
Такой подход позволяет работать с бесконечными последовательностями и находить наименьшее кратное число без лимита на количество итераций.

[Решение](src/tasks/Task5Inf.clj)


## Решения для Задачи 26

Задача 26 (Project Euler): Нахождение числа d < 1000, для которого дробь 1/d в десятичном виде имеет самую длинную повторяющуюся последовательность цифр.

### 1. **Хвостовая рекурсия (`Task26TailRec`)**
Этот модуль применяет хвостовую рекурсию для эффективного вычисления:

```clojure
  (defn longest-repeating-cycle-tail [limit]
    (loop [d 2
           max-length 0
           result 0]
      (if (< d limit)
        (let [cycle-length (length-of-repeating-cycle d)]
          (if (> cycle-length max-length)
            (recur (inc d) cycle-length d)
            (recur (inc d) max-length result)))
        result)))
```

Лаконичное и эффективное решение для нахождения числа с самой длинной повторяющейся последовательностью с использованием хвостовой рекурсии, что позволяет избежать переполнения стека.

[Решение](src/tasks/Task26TailRec.clj)

### 2. **Рекурсия (`Task26Rec`)**
Этот модуль использует стандартную рекурсию для нахождения длины цикла:

```clojure
(defn longest-repeating-cycle-recur [limit]
    (loop [d 2 max-length 0 result 0]
      (if (< d limit)
        (let [cycle-length (length-of-repeating-cycle d)]
          (if (> cycle-length max-length)
            (recur (inc d) cycle-length d)
            (recur (inc d) max-length result)))
        result)))
```

Простое рекурсивное решение, которое проверяет каждое число на наличие повторяющихся циклов.

[Решение](src/tasks/Task26Rec.clj)

### 3. **Модульное решение (`Task26Module`)**
Модульное решение структурирует код для удобного использования функций:

```clojure
(defn longest-repeating-cycle-module [limit]
  (reduce (fn [acc d]
            (let [cycle-length (length-of-longest-repeating-cycle d)]
              (if (> cycle-length (second acc))
                [d cycle-length]
                acc)))
          [0 0] (range 2 limit)))
```

Каждая функция отвечает за определенную задачу, что делает код читаемым и расширяемым.

[Решение](src/tasks/Task26Module.clj)

### 4. **Использование `map` (`Task26Map`)**
Этот модуль применяет `map` для применения функций к последовательностям:

```clojure
(defn longest-repeating-cycle-map [limit]
  (let [lengths (map length-of-longest-repeating-cycle (range 2 limit))]
    (first (reduce (fn [m len] 
                     (if (> (second len) (second m))
                       len 
                       m))
                   [0 0]
                   (map vector (range 2 limit) lengths)))))
```

Использование `map` делает код кратким и эффективным при обработке последовательностей.

[Решение](src/tasks/Task26Map.clj)

### 5. **Использование циклов (`Task26Loop`)**
Циклы используются для итеративного решения задачи:

```clojure
(defn longest-repeating-cycle-loop [limit]
  (loop [d 2 max-length 0 result 0]
    (if (< d limit)
      (let [cycle-length (length-of-longest-repeating-cycle d)]
        (if (> cycle-length max-length)
          (recur (inc d) cycle-length d)
          (recur (inc d) max-length result)))
      result)))
```

Циклы обеспечивают предсказуемое выполнение и быстрое решение.

[Решение](src/tasks/Task26Loop.clj)

## Тестирование

[Тесты для 5 задания](test/tasks/Task5Tests.clj)  
[Тесты для 26 задания](test/tasks/Task26Tests.clj)

## Заключение

Представленные примеры показывают разнообразные методы решения задач с использованием функционального программирования в Clojure. Они иллюстрируют, как рекурсия, циклы и функции высшего порядка могут эффективно применяться для математических задач. 
