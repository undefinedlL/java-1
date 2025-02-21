### Ссылка на презентацию

https://docs.google.com/presentation/d/1-u63bxxBM5ADAAYCFm6dqrBOfiEdJ6oaQWtlnZdDhnk/edit?usp=sharing


#### CSS 
```
<style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh; 
        }
        .container {
        }
        h1 {
        }
        .input {
        }
        label {
        }
        input {
        }
        .btn {
        }
    </style>
```


#### Полный HTML/CSS код
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Урок 16</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh; 
            background-color: #f0f0f0; 
        }
        .container {
            width: 300px; 
            padding: 20px;
            background-color: white;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); 
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .input {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555; 
        }
        input {
            width:100%;
            padding: 10px ; 
            border: 1px solid #ccc ; 
            border-radius: 4px ; 
        }
        .btn {
            background-color: #4CAF50; 
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input:focus { 
            outline: none; 
            border-color: #4CAF50; 
            box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Вход</h1>
        <form action="#">
            <div class="input">
                <label for="login">Логин</label>
                <input type="text" id="login">
            </div>
            <div class="input">
                <label for="pwd">Пароль</label>
                <input type="password" id="pwd">
            </div>
            <button class="btn" type="submit">Войти</button>
        </form>
    </div>
</body>
</html>
```