<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
main {
    width: 500px;
    margin: auto;
}
h2 {
    margin: 1.5em;
    text-align: center;
}

.table td {
    vertical-align: middle
}
</style>
<?php
require_once __DIR__ . '/vendor/autoload.php';

$apiInstance = new OpenAPI\Client\Api\TasksApi();

try {

    if ($_POST['action'] == "create") {
        $newTask = new OpenAPI\Client\Model\TaskWrite();

        $newTask->setText($_POST['text']);
        $newTask->setDone(0);

        $apiInstance->createTask($newTask);
    } elseif ($_POST['action'] == "update") {
        $task = $apiInstance->getTaskById($_POST['id']);
        $task->setDone(1);

        $apiInstance->updateTask($_POST['id'], $task);

    } elseif ($_POST['action'] == "delete") {
        $apiInstance->deleteTask($_POST['id']);

    }

    $tasks = $apiInstance->getTasks();

} catch (Exception $e) {
    echo $e->getMessage(), PHP_EOL;
}
echo "<main><h2>c't Task Frontend</h2>";
if (count($tasks)) {
    echo "<table class='table table table-striped'>";
    foreach ($tasks as $task) {
        echo "<tr><td>";

        if ($task->getDone()) {
            echo "<strike>";
        }

        echo $task->getText();
        if ($task->getDone()) {
            echo "</strike></td><td>";

        } else {
            echo "</td><td>
        <form action='index.php' method='post'>
            <input type='hidden' name='action' value='update' />
            <input type='hidden' name='id' value='" . $task->getId() . "'/>
            <input class='btn btn-secondary' type='submit' value='erledigen'>
        </form>";

        }

        echo "</td><td>
        <form action='index.php' method='post'>
            <input type='hidden' name='action' value='delete' />
            <input type='hidden' name='id' value='" . $task->getId() . "'/>
            <input type='submit' class='btn btn-danger' value='löschen'>
        </form>";
        echo "</td></tr>";
    }
    echo "</table>";
} else {
    echo "<div class='alert alert-primary'>Es existieren noch keine Aufgaben!</div>";
}

echo "

        <form action='index.php' method='post'>
            <input type='hidden' name='action' value='create' />
            <div class='form-row' style='width: 100%;'>
                <div class='col'>
                    <input type='text' class='form-control' name='text' placeholder='neue Aufgabe'/>
                </div>
                <div class='col-auto'>
                    <input type='submit' class='btn btn-primary' value='erstellen'>
                </div>
            </div>
        </form>
        ";

echo "</main>";
