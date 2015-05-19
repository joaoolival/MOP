
Este package pretende mostrar uma implementa��o simples do padr�o MVC 
(Model-View-Controller).

Assim, temos uma classe de nome ChangeNotifier que se destina e propagar
eventos de altera��o, ou seja, ChangeEvents. Esta classe tamb�m permite
o registo de ChangeListeners, ou seja, o registo de objectos quer querem 
receber notifica��es (eventos) de altera��o de estado.

Um Model deve possuir uma inst�ncia desta classe de modo a permitir o 
registo de ChangeListeners e permitir a difus�o de ChangeEvents.

Ent�o um Viewer tem de registar um seu ChangeListener no Model (ou melhor 
no objecto ChangeNotifier do Model), � por isso que um model tem de 
implementar a interface IChangeNotifier, para que se saiba que tem um
m�todo de registo de ChangeListeners.

Um controller actua sobre o model, atrav�s dos seus m�todos de setValue, 
ou outros do g�nero. Aqui n�o se criou m�todos com nome predefinidos.
