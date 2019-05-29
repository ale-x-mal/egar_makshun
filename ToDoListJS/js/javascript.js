		//функция для сохарнения задач в куки, чтобы не потерять данные
        function saveState() {

            var notReady = [];
            var ready = [];

            //сохарняем в массив не выполненные задачи
            $('#list-not-ready li.task span').each(function(i, el) {
                //кодируем значения для корректного храненияи и отображения 
                //таких символов как пробел и двоеточие
                var val = encodeURI($(el).text());
                notReady.push(val);
            });

            //сохарняем в массив выполненные задачи
            $('#list-ready li.task span').each(function(i, el) {
                //кодируем значения для корректного храненияи и отображения 
                //таких символов как пробел и двоеточие
                var val = encodeURI($(el).text());
                ready.push(val);
            });

            //сохраняем массивы в строку с разделителями
            var result = notReady.join('&') + '|' + ready.join('&');

            //устанавливаем время жизни кук в один месяц
            var time = new Date();
            time.setTime(time.getTime() + 2678400000);

            //сохраняем куки
            document.cookie = 'data=' + result + "; expires=" + time.toUTCString();
        }

        //фунция для востановления задач из куков
        function loadState() {

            // парсит задачи из массива и добавляет их в соответствующие списки
            var addList = function(strList, isComplete) {
                var list = strList.split('&');
                for (var i = 0; i < list.length; i++) {
                    if (list[i]) {
                        addTask(decodeURI(list[i]), isComplete);
                    }
                }
            }

            // возвращает значение куки по имени
            var getCookie = function(name) {
                //ищем индекс начала значения с именем "name"
                var startIndex = document.cookie.indexOf(name);
                if (startIndex == -1) {
                    return ''
                };

                startIndex = document.cookie.indexOf(name + "=")
                if (startIndex == -1) {
                    return ''
                };

                //ищем индес конца значения с именем "name"
                var endIndex = document.cookie.indexOf(";", startIndex + (name + "=").length);
                if (endIndex == -1) {
                    endIndex = document.cookie.length;
                }

                //вырезаем из куки и возвращаем значение параметра "name"
                return document.cookie.substring(startIndex + (name + "=").length, endIndex);
            }

            //сохраняем в массив части из выполненных и не выполненных задач
            var parts = getCookie('data').split('|');

            //отправляем в метод не выполненные задачи
            addList(parts[0], false);

            if (parts.length > 1) {
                //отправляем в метод выполненные задачи
                addList(parts[1], true);
            }
        }

        //функция заносит задачи в нужный список
        function moveTask(li, isComplete) {
            var taskList = isComplete ? '#list-ready' : '#list-not-ready';
            li.appendTo(taskList);
            saveState();
        }

        //функция для добавления задачи
        function addTask(val, isComplete) {

            var del = $('<input class="del" type="image" src="img/Trash.jpg" />');
            var checkbox = $('<input type="checkbox" />');

            // проверяем задачу на важность (если важная, добавляем в начало 3 вокл. знака)
            if ($('#important').prop('checked')) {
                val = '!!! ' + val;
                $('#important').prop('checked', false);
            };

            var span = $('<span />').text(val);

            //если важная, выделяем жирным
            if (val.startsWith('!!!')) {
                var li = $('<li class="task" style="font-weight: 600" />').append(del).append(' ').append(checkbox).append(span);
            } else {
                var li = $('<li class="task" />').append(del).append(' ').append(checkbox).append(span);
            };

            //переносим задачу в выволненные при отметке галочки
            checkbox.click(function() {
                moveTask(li, checkbox.prop('checked'));
            }).prop('checked', isComplete);

            //удаляем задачу
            del.click(function() {
                li.remove();
                saveState();
                return false;
            });

            moveTask(li, isComplete);
        }

        $(function() {

            //сохраняем введеную задачу при нажатии кнопки "Добавить"
            $('#btn-add').click(function() {
                var val = $('#new-todo').val();
                if (val) {
                    addTask(val);
                    $('#new-todo').val('');
                }
                return false;
            });

            //сохраняем введеную задачу при нажатии клавиши Enter
            $('#new-todo').keypress(function(e) {
                if (e.keyCode == 13) {
                    $('#btn-add').click();
                }
            });

            //для сортировки текущих задач перетаскиванием
            //после перетаскивания сохраняем состояние в куках
            $('#list-not-ready').sortable({
                deactivate: saveState
            });

            //очистить списки задач
            $('#btn-remove-all').click(function() {
                $('#list-ready').empty();
                $('#list-not-ready').empty();
                saveState();
                return false;
            });

            //удалить все выполненные
            $('#btn-remove-completed').click(function() {
                $('#list-ready').empty();
                saveState();
                return false;
            });

            $('#b').click(function() {
                exportToCsv();
            });

            loadState();
        });
