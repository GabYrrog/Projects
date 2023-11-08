document.addEventListener('DOMContentLoaded', () => {
    const groceryForm = document.querySelector('.ListHead');
    const groceryList = document.querySelector('.GroceryList');
    const itemInput = document.querySelector('.Item');
    const quantityInput = document.querySelector('.Quantity'); 
    const editIndexInput = document.createElement('input');
    editIndexInput.type = 'hidden';
    editIndexInput.className = 'EditIndex';
    groceryForm.appendChild(editIndexInput);
    const maxItemsHeight = 440;
    let items = [];

    groceryForm.addEventListener('submit', function(event) {
        event.preventDefault();
        const editIndex = editIndexInput.value;
        const newItem = itemInput.value.trim();
        const newQuantity = quantityInput.value.trim(); 

        if (newItem && newQuantity) {
            const itemWithQuantity = { name: newItem, quantity: newQuantity }; 
            const tempItem = document.createElement('p');
            tempItem.textContent = newItem + " (" + newQuantity + ")";
            groceryList.appendChild(tempItem);
            const isOverflowing = groceryList.scrollHeight > maxItemsHeight;
            groceryList.removeChild(tempItem);

            if (editIndex !== '') {
                items[parseInt(editIndex, 10)] = itemWithQuantity;
                editIndexInput.value = '';
            } else {
                if (!isOverflowing) {
                    items.push(itemWithQuantity);
                } else {
                    alert("No more room to add items!");
                }
            }

            updateList();
            itemInput.value = '';
            quantityInput.value = ''; 
            itemInput.focus();
        }
    });

    function updateList() {
        groceryList.innerHTML = '';

        items.forEach((itemObject, index) => {
            const itemContainer = document.createElement('div');
            itemContainer.className = 'item-container';

            const pItem = document.createElement('p');
            pItem.textContent = itemObject.name + " - Quantity: " + itemObject.quantity; 
            pItem.className = 'item-text';
            itemContainer.appendChild(pItem);

            const modifyBtn = document.createElement('button');
            modifyBtn.textContent = 'Modify';
            modifyBtn.className = 'modify-btn';
            modifyBtn.onclick = function() {
                itemInput.value = itemObject.name;
                quantityInput.value = itemObject.quantity; 
                itemInput.focus();
                editIndexInput.value = index;
            };
            itemContainer.appendChild(modifyBtn);

            const removeBtn = document.createElement('button');
            removeBtn.textContent = 'Remove';
            removeBtn.className = 'remove-btn';
            removeBtn.onclick = function() {
                items.splice(index, 1);
                updateList();
            };
            itemContainer.appendChild(removeBtn);

            groceryList.appendChild(itemContainer);
        });
    }
});
