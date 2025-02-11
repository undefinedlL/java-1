# Занятие 9. Создание компьютерной игры "Новогодний дождь" (продолжение)

### На этом занятии:
Мы начнем создавать непосредственно "Новогодний дождь" из подарков. Сегодня мы создадим шаблон, на основании которого можно будет загружать любое количество объектов.

Для этого нам нужно будет:
- создать новый класс, подключить необходимые библиотеки;
- познакомиться с таким понятием как массив (массив позволяет хранить в системе целые наборы значений);
- познакомимся с методом random(), позволяющим выбирать тот или иной подарок в случайном порядке.


Откроем среду разработки Eclipse.

### Вспомним!
На прошлом занятии мы начали писать компьютерную игру. Создали для неё фон. Затем создали основной элемент в нижней части экрана - шапку Деда Мороза, чтобы ловить ею новогодние подарки, падающие сверху. Был создан проект под названием game. Внутри папки с проектом находятся три файла с расширением java: Game.java, Window.java и Field.java. Откроем все три файла, чтобы они появились на экране. Запустим программу на исполнение, проверим, всё ли работает: при нажатии клавиш влево и вправо, шапочка Деда Мороза перемещается, соответственно, вправо и влево; когда она уходит за пределы экрана, появляется с противоположной стороны. При нажатии Esc происходит выход из игры.

Прежде чем продолжить создание игры, давайте познакомимся с таким понятием, как массивы, т.к. оно нам пригодится в дальнейшем.

Мы уже много работали с переменными, и знаем, что переменная - это область оперативной памяти, которая имеет имя. Обращаясь к этому имени, можно положить какое-то значение в данную область оперативной памяти, т. е., задать новое значение; можно получить значение, находящееся в этой области. Массив - более сложная структура, представляющая собой несколько областей оперативной памяти, находящихся последовательно, друг за другом. Эти ячейки связаны в единое целое. Можно сказать, что массив - это группа пронумерованных переменных, каждая из которых имеет свой номер.

Рассмотрим некую условную модель - секцию, состоящую из семи квадратиков - "шкафчиков". Внутри каждого из квадратиков записано целое число, отдельный "шкафчик". Так вот, массив - это набор, коллекция, таких "шкафчиков". Все эти "шкафчики" объединены в одну секцию, в один отдел. Секция имеет одно название. Название определяется так же, как имя переменной: можно указать любое сочетание букв, цифр. В данном случае, это название mas. Название объединяет в единое целое все яченки. У каждой из ячеек есть свой номер.

Возвращаясь к модели: у нас есть семь "шкафчиков", пронумерованных по порядку.
Нумерация всегда обязательно начинается с нуля, т. е., самый первый "шкафчик" имеет номер 0. Соответственно, потом 1, 2, 3, 4, 5 и 6.

Элементы массива нумеруются всегда по порядку, начиная с нуля.

Для удобства работы с элементом массива, после имени массива указываются квадратные скобки [], внутри квадратных скобок указывается индекс, то есть номер нужной ячейки, или "шкафчика". Если обратиться к шкафчику с номером 0, открыв его дверцу, то можно найти внутри цифру 5. Далее, обратимся к шкафчику с номером 1, откроем его дверцу и найдём там цифру 2. Точно так же, по номеру любого шкафчика можно обратиться к его содержимому. По такому принципу идёт работа с элементами массива. Массив внутри себя хранит несколько значений. В данном случае, у нас семь значений, их может быть больше или меньше, может быть всего одно, а может, допустим, 100. При создании массива указывается конкретное количество значений, которые он будет хранить. Массив, это набор переменных: каждая ячейка (или "шкафчик"), содержит отдельную переменную. К конкретной переменной массива можно обратиться, указав название массива и номер её ячейки. Если обычная переменная хранится в отдельной ячейке со своим названием, то переменная массива хранится в одной из пронумерованных ячеек области массива, имеющего определённое название.

Область массива имеет одно общее наименование, в данном случае arr. Обращение к каждой его ячейке происходит по её номеру - индексу. Номер ячейки называется индексом массива. В каждой ячейке можно хранить любое значение, так же, как в случае простой переменной.

Запишем строку: arr[0]=20;, т. е., в ячейку с индексом 0, туда, где сейчас находится цифра 5, помещаем значение 20. Теперь в ячейке с номером 0 находится значение 20. Обратимся опять к массиву arr. Обращаясь к arr, мы обращаемся ко всей области ячеек этого массива. Укажем индекс 3, т. е., обратимся к ячейке с номером 3, содержащей значение 3, и присвоим ей значение 30.

Таким образом, в ячейку с номером 3 помещается теперь значение 30. При помощи массива можно работать с целой группой переменных. Раньше мы могли объявлять одну переменную. Теперь, обьявляя массив, можно создавать, целую группу переменных в нужном количестве. Как и переменные, массивы могут быть разных типов. Если массив, как в нашем случае, является массивом целых чисел, это массив типа int. Массив может быть и другого типа, боле сложного, например, типа JFrame, т. е., каждый элемент массива будет хранить в себе окно, которое может быть выведено на экран.

При создании игры мы будем использовать массив как "хранилище подарков", т. e., создадим массив для хранения изображений подарков. Изображения загрузим из файлов, недавно помещённых в корневую папку диска С. Таким образом, массив будет хранить 7 изображений. Соответственно, каждый элемент массива будет хранить одно изображение.

Итак, вернемся в среду разработки Eclipse и перейдём к основной части занятия - созданию нового класса.

Добавим ещё один класс к нашему проекту. Этот класс будет отвечать за работу подарков на игровом поле, поэтому назовем его словом Gift (наименование, конечно же, может быть и другим). Для этого наведем курсор мыши на название проекта, нажмём правую клавишу Создать, Класс. В наименовании класса укажем слово Gift. Галочку public static void main можно здесь не устанавливать, т.к. этот метод в данном классе нам не понадобится. Метод public static void main находится в главном классе программы, запускаемом на выполнение. Нажмём кнопку Готово, появился новый класс под названием Gift. Внутри этого класса мы опишем все свойства и все возможные действия, связанные с подарками.

Какие свойства могут быть у изображения подарка? Прежде всего, координаты х и у, координаты его положения на игровом поле. Второе - имя картинки, на которой изображён ланный подарок. Эти картинки мы будем загружать из файлов, добавленных ранее на диск С.

Далее, у подарка будет ещё одно свойство, его активность. Если свойство активность - false, т. е., ложь, подарок не будет отображаться на игровом поле. Если же это свойство будет равно true - истина, подарок будет отображаться на игровом поле. Таким образом, через это свойство мы будем регулировать, нужно отображать подарок на игровом поле, или нет.

Прежде чем формировать класс, при помощи команды import, в самом верху добавим три библиотеки, которые понадобятся для реализации класса:

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Gift {

}
```

Первая библиотека нужна для возможности работы с окнами, вторая библиотека - для работы с графикой, и третья - для обработки событий (event - событие). В данном случае, будет идти обработка события по таймеру.

Вспомним, при подключении библиотек становятся доступны команды или методы, описанные в этих библиотеках. Если мы их не подключим, команды, находящиеся в этих библиотеках, использовать не сможем (программа команды не поймет, т.к. не определит, где она находится). Добавим переменные класса:

```
public class Gift {
    private Image img;
    public int x, y;
    public Boolean act;
    private Timer timerUpdate;


}
```

Первая переменная типа Image - картинка. Картинка будет загружаться из файла с диска С и потом отображаться на экране. Имя переменной - img (имя может быть любым). Переменная private, закрытая. Это значит, что переменная img доступна только при обращении к ней внутри класса. Вторая и третья переменные - координаты х и у, они целого типа, int, открытые, public. Соответственно, эти две переменные доступны и за пределами класса. Переменные х и у отвечают за отступ в пикселях: х - от левой части экрана, а у - от верхней части экрана. Когда подарок появляется сверху, координату х менять не нужно, т. е., отступ слева остаётся одним и тем же. А отступ сверху, координату у, нужно постоянно увеличивать для описания движения подарка вниз. Далее, создаём переменную типа Boolean, логический тип, имеющий всего два значения: либо истина, либо ложь. Назовём её асt. Эта переменная отвечает за активность подарка. Если переменная асt равна true - истина, подарок отображается на экране. Если же она равна false - ложь, подарок не отображается на экране. И последняя переменная: типа Timer. Это переменная по имени timerUpdate - наш таймер, который отвечает за движение подарка вниз. Продолжаем последовательно наполнять класс. Необходимые переменные уже описаны, теперь приступим ко второй части: к созданию методов класса. Методы отвечают за действия. Если переменная - это свойства, характеристики, то методы - это действия. Движение подарка вниз - это действие.
Создадим конструктор класса. Конструктор класса - метод, который производит инициализирующие, стартовые действия при создании объекта. Конструктор класса всегда называется так же, как и сам класс: имя класса всегда должно совпадать с именем конструктора класса.

```
public Gift(Image img) {
    timerUpdate = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            down();
        }
    });

    this.img = img;
    act = false;
}
```

Внутри круглых скобок конструктора указываем переменную типа Image, картинка. Это необходимо для того, чтобы при создании объекта указать конкретную картинку, изображение данного подарка. Теперь создадим обработчик для таймера, укажем в нем временную задержку в тысячных секунды - это время, через которое таймер будет срабатывать, выполнять определенное действие. Наш таймер будет выполнять через каждые 500 тысячных секунды (через полсекунды) метод по названием down;. Этот метод будет выполнять движение подарка вниз, сам метод мы создадим ниже в нашем классе, а пока укажем только его вызов. Пока этот метод не описан, он подчеркивается красным цветом. На это пока не стоит обращать внимание. Далее, после описания таймера записывается строка:

```
this.img = img;
```

В этой строке переменная из круглых скобок конструктора присваивается переменной класса с таким же наименованием. Когда будет создаваться объект этого класса, то в круглых скобках будет передаваться загруженное с диска С изображение подарка. Таким образом, после создания объекта, за ним будет закрепляться конкретная картинка. Далее, переменной act присваивается значение false - ложь, т. к. в самом начале подарок неактивен на игровом поле, он не отображается и не перемещается, находясь пока в пассивном состоянии.

После конструктора создадим метод, который активизирует подарок на игровом поле, выполняет его появление:

```
public void start() {
    timerUpdate.start();
    y = 0;
    x = (int)(Math.random()*700);
    act = true;
}
```

Метод открытый - public; void означает, что метод не возвращает никакого значения. В первой строке метода мы запускаем таймер timerUpdate. Таймер начинает работать, отсчитывается время, и таймер каждый раз выполняет команду под названием down();, каждый раз перемещая объект все ниже и ниже. Далее, переменной у мы присваиваем значение 0, т. е., если у=0, отступ от верхней части экрана нулевой: подарок находится в самой верхней части (точнее, верхняя граница картинки находится в самом верху игрового поля). Именно это нам и необходимо при старте: вывести подарок на экран, к самой верхней его части. Команда start начинает движение подарка вниз, его падение. Далее, переменной х присваивается случайное значение:

```
x = (int)(Math.random()*700);
```

Это необходимо для того, чтобы каждый подарок появлялся в самой верхней части игрового поля в непредсказуемом, случайном месте.

Очень часто при создании компьютерных игр необходимо выбирать какое-то случайное значение среди определенного интервала чисел. В данном случае, переменная х получает случайное значение в диапазоне от нуля до 700. 700 - это как раз примерно ширина окна игрового поля. Ширина подарка около 100 пикселей, и мы специально выбираем интервал от нуля до 700, чтобы подарок всегда полностью помещался на экране.

Рассмотрим подробнее, как работает строка, присваивающая переменной х случайное значение. Math.random() - метод, который возвращает случайное число. Каждый раз оно выбирается случайным образом, нельзя предсказать его значение. Но это число всегда возвращается в интервале от нуля до единицы в дробном виде: ноль, точка, и после точки идёт какое-то количество разрядов дробной части. Например: 0.238362.

Между нулем и единицей лежит очень много дробных чисел, поэтому чисел, которые будут возвращаться при помощи random(). Чтобы получить значение в интервале от нуля до 700, необходимо этот результат умножить на 700. Таким образом, если ноль умножить на 700, получается ноль, минимальное значение. При умножении единицы на 700, получится 700, максимальное значение. Значит, строка Math.random(), умноженная на 700, будет возвращать случайное число в интервале от нуля до 700, и эти числа будут также дробными, так как на 700 умножалось дробное число.

Допустим, Math.random() может вернуть число: 51.9237. Или, например, 128.1927. Или 678.5078. 51, 128 и 678 - это целая часть, а то, что стоит после точки, - дробная часть. Однако, пиксели - это целые значения: 0, 1, 2, 3 и так далее. Таким образом, нам нужно получать именно целые, а не дробные значения от нуля до 700. Для того, чтобы это было возможным, необходимо конструкцию Math.random(), умноженную на 700, взять в круглые скобки ( ) и перед этой конструкцией, так же, в круглых скобках, указать іnt. Тогда результат этого выражения будет приводиться к целому типу, а дробная часть будет отбрасываться:

```
x = (int)(Math.random()*700);
```

Например, если перед этим преобразованием число было 51.9237, после преобразования оно будет равно 51, и переменной х будет присваиваться случайное целое число от нуля до 700.

Подарок будет выводиться в разные области верхней части окна непредсказуемо, и игра станет интереснее. В последней строчке кода метода start() переменной асt присвоим значение истина, true. Теперь подарок активен на игровом поле. Метод start() как раз отвечает за активизацию объекта. Таким образом, наш подарок будет отображаться на рабочем поле и перемещаться вниз, т. e., падать. Теперь создадим в классе следующий метод назовём eго down. Метод открытый, public: Он не будет возвращать никакого значения, то есть void:

```
public void down() {
    if (act == true) {
        y += 6;
    }
    if (y+img.getHeight(null) >= 470) {
        timerUpdate.stop();
    }
}
```

У метода нет никаких параметров, поэтому его круглые скобки пустые. Фигурными скобками (открывающей и закрывающей) определяется начало и окончание тела метода. Этот метод, down(), мы указывали, когда описывали таймер. Т. е. таймер через определенный интервал времени будет вызывать метод down. Метод down будет перемещать объект, изменяя его координату у - отступ от верхней части окна. Чем больше координата у, тем ниже будет находиться подарок. Первое, что указывается в этом методе - это конструкция if.


### Важно!

Двойной знак равенства здесь говорит именно о сравнении, а не о
присвоении.

Знак равенства должен быть именно двойным!


Здесь мы анализируем переменную асt, равна ли она true (истине), является ли подарок сейчас активным на игровом поле. Если условие выполняется, то мы увеличиваем переменную у на 6: у+=6; Эта строка означает, что к значению переменной у будет прибавляться 6. Таким образом, подарок будет смещаться вниз на 6 пикселей, так как его координата у увеличивается на 6. До какого же максимального значения координаты у подарок должен падать вниз? Максимальная граница снизу определяется положением шапочки Деда Мороза: Если картинка достигла границы, определяемой горизонтальным движением шапочки Деда Мороза, ниже подарок двигаться не может: либо он пойман при помощи шапки Деда Мороза, либо, наоборот, пропущен. В любом случае, в этот момент нужно убрать подарок с поля.

Эту задача решается с помощью следующей конструкции if.

```
if (y + img.getHeight(null) >= 470) {
    timerUpdate.stop();
}
```

Если значение переменной у плюс высота подарка больше или равна 470, то это означает, что подарок достиг нижней границы. Метод getHeight определяет высоту картинки в пикселях. В скобках указан параметр null, - пустой параметр. Значение 470 соответствует положению верхней границы шапочки Деда Мороза, его можно сначала указать приблизительно, а потом в процессе запуска игры - смотреть, насколько точно подарок достигает нижней границы и корректировать это значение - увеличивать или уменьшать. Значит, если значение координаты у плюс высота рисунка в сумме стало больше или равно 470 пикселей, подарок останавливается - мы выключаем его таймер: timer Update.stop();. В этом методе мы будем дополнительно к отключению таймера отключать и активность подарка, и он будет исчезать с игрового поля. Здесь возможны два варианта: либо подарок пропущен, не пойман, тогда происходит окончание игры; либо подарок пойман. Таким образом, метод down будет производить следующие действия: Он будет увеличивать значение координаты у, отступ от верхней части окна. Когда подарок пересечёт границу там, где он должен быть пойман, он убирается с рабочего поля. Метод down() вызывается каждый раз при срабатывании таймера, в нашем случае это будет происходить один раз в полсекунды. И последний метод, который необходимо добавить, метод (назовём его draw(), от слова рисовать), отвечающий за рисование объекта на экране, за его отображение.

```
public void draw(Graphics gr) {
    if (act == true) {
        gr.drawImage(img, x, y, null);
    }
}
```

Этот метод так же открытый, public. Он также не будет возвращать никакого значения, то есть void. Внутри круглых скобок этого метода находится параметр типа Graphics. Дадим имя переменной, например gr (имя может быть и другим). Если метод down() всего лишь меняет значение переменной у, метод draw() осуществляет рисование. Внутри фигурных скобок метода draw записана конструкция if. Если подарок активен, он выводится на игровое поле помощи метода drawImage(). Если он не активен - не выводится. Мы обращаемся к переменной gr, отвечающей за вывод графики, и, при помощи оператора (.) вызываем команду drawImage(). Внутри круглых скобок команды drawImage() необходимо указать четыре параметра. Первый - img, картинка. Переменная img, которая была определена в самом верху класса, отвечает за картинку, связанную с подарком. Именно это изображение будет выводиться на экран. Далее идут две координаты: х и у. Они определяют точку вывода на экран верхнего левого угла изображения (ещё раз вспомним, координата положения изображения на экране определяется положением его верхнего левого угла). Координата у меняется внутри метода down, увеличиваясь с каждым шагом на 6 единиц, поэтому каждый последующий раз картинка будет отрисована всё ниже и ниже на экране. И, наконец, последний параметр, null - пустой параметр. Метод draw() будет рисовать только в случае, если подарок активен, т. с., если свойство act равно true. В тот момент, когда подарок пересечет самую нижнюю, разрешённую для него линию, метод down() будет останавливать таймер для этого подарка. Подарок перестанет перемещаться вниз. Таким образом, мы создали класс. Его полный программный код выглядит так:

```
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Gift {
    public Image img;
    public int x, y;
    public Boolean act;
    Timer timerUpdate;

    public Gift(Image img) {
        timerUpdate = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });
        this.img = img;

        act = false;
    }

    public start() {
        timerUpdate.start();
        y = 0;
        x = (int)(Math.random()*700);
        act = true;
    }

    public void down() {
        if (act == true) {
            y+=6;
        }
        if ((y+img.getHeight(null)) >= 470) {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics gr) {
        if (act == true) {
            gr.drawImage(img, x, y, null);
        }
    }
}
```

Теперь он полностью закончен. Внутри этого класса реализовано всё, связанное с подарком. Мы описали класс Gift, сделали шаблон. Теперь на его основании можно создавать любое количество объектов. После запуска программы, содержащей лишь класс и при отсутствии созданных на его основании объектов, ничего нового мы не увидим - ни подарков, ни их движения. Нельзя увидеть свойства и действия объекта при отсутствии самого объекта, а объекты ещё не созданы и не прописаны в программе. Пока есть только класс (шаблон, описание), на основании которого можно создавать объекты. Все объекты, подарки, созданные в дальнейшем на основании класса Gift, будут иметь одинаковые свойства. Все они будут появляться в верхней части игрового поля, затем начнут падать вниз. Каждый подарок характеризуется своей картинкой, своим изображением, и каждый будет в текущий момент находиться в разной точке экрана, то есть какой-то может находиться выше, какой-то ниже. Таким образом, создав класс, один раз его настроив, и прописав в нём все необходимые для игры свойства объекта, на его основании теперь можно создать любое количество реальных объектов, которые можно будет увидеть на экране. Можно, например, создать 100 объектов. Уже не придётся прописывать их поведение на экране, нужно всего лишь вызывать команды класса. При вызове команды start(), подарок будет появляться в верхней части в случайном месте. При вызове команды down (автоматически, при срабатывании таймера), подарок начнёт перемещаться вниз. При вызове команды draw(), подарок будет отрисован в новой точке. Таким образом, создав класс, потом можно его использовать, пользоваться его функционалом.

Увидеть созданный выше класс Gift в действии мы сможем на следующем занятии, когда начнём загружать графические файлы из корня диска С в программу, т. е., создадим реальные объекты на основании этого класса.