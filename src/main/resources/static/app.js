const API = '/api/bills';
const tableBody = document.querySelector('#billsTable tbody');
const form = document.getElementById('billForm');
const msg = document.getElementById('msg');
const refreshBtn = document.getElementById('refreshBtn');

async function fetchBills(){
  try {
    const res = await fetch(API);
    const data = await res.json();
    renderTable(data);
  } catch(e){
    console.error(e);
    msg.textContent = 'Error fetching bills';
  }
}

function renderTable(bills){
  tableBody.innerHTML = '';
  bills.forEach(b => {
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${b.id ?? ''}</td>
                    <td>${escapeHtml(b.patientName)}</td>
                    <td>${escapeHtml(b.treatment)}</td>
                    <td>₹ ${Number(b.amount).toFixed(2)}</td>`;
    tableBody.appendChild(tr);
  });
}

function escapeHtml(text){ if(!text) return ''; return text.replace(/[&<>"']/g, s=>({ '&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":'&#39;' }[s])); }

form.addEventListener('submit', async (e)=>{
  e.preventDefault();
  const payload = {
    id: Math.floor(Math.random()*1000000),
    patientName: document.getElementById('patientName').value.trim(),
    treatment: document.getElementById('treatment').value.trim(),
    amount: parseFloat(document.getElementById('amount').value)
  };
  try {
    const res = await fetch(API, { method:'POST', headers:{'Content-Type':'application/json'}, body: JSON.stringify(payload)});
    const text = await res.text();
    msg.textContent = text;
    form.reset();
    fetchBills();
  } catch(err){
    console.error(err);
    msg.textContent = 'Failed to add bill';
  }
});

refreshBtn.addEventListener('click', ()=>fetchBills());

// initial load
fetchBills();
