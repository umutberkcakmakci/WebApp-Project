document.addEventListener('DOMContentLoaded', () => {
    const awardsListElement = document.getElementById('awards-list');
    const awardDetailsElement = document.getElementById('award-details');
    const addAwardForm = document.getElementById('add-award-form');
  
    // Load the list of awards
    if (awardsListElement) {
      loadAwardsList();
    }
  
    // Load award details if on details page
    if (awardDetailsElement) {
      const urlParams = new URLSearchParams(window.location.search);
      const awardId = urlParams.get('awardId');
      if (awardId) {
        loadAwardDetails(awardId);
      }
    }
  
    // Handle add award form submission
    if (addAwardForm) {
      addAwardForm.addEventListener('submit', event => {
        event.preventDefault();
        const formData = new FormData(addAwardForm);
        const awardData = Object.fromEntries(formData);
        addAward(awardData);
      });
    }
  
    function loadAwardsList() {
      fetch('http://localhost:8080/movie-webapp-1.00/add-award')
        .then(response => response.json())
        .then(data => {
          awardsListElement.innerHTML = '';
          data.forEach(award => {
            const awardCard = document.createElement('div');
            awardCard.className = 'award-card';
            awardCard.innerHTML = `
              <h3>${award.category}</h3>
              <p>Winner: ${award.winnerName}</p>
              <p>Year: ${award.year}</p>
              <button onclick="deleteAward(${award.awardId})">Delete</button>
              <a href="award-details.html?awardId=${award.awardId}">View Details</a>
            `;
            awardsListElement.appendChild(awardCard);
          });
        })
        .catch(error => console.error('Error fetching awards:', error));
    }
  
    function loadAwardDetails(awardId) {
      fetch('http://localhost:8080/movie-webapp-1.00/award-details')
        .then(response => response.json())
        .then(data => {
          awardDetailsElement.innerHTML = `
            <h2>${data.category}</h2>
            <p>Winner: ${data.winnerName}</p>
            <p>Year: ${data.year}</p>
            <p>Genre: ${data.genre}</p>
            <p>Movie ID: ${data.movieId}</p>
            <p>Person ID: ${data.personId}</p>
          `;
        })
        .catch(error => console.error('Error fetching award details:', error));
    }
  
    function addAward(awardData) {
      fetch('http://localhost:8080/movie-webapp-1.00/add-award', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(awardData)
      })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          window.location.href = 'index.html';
        } else {
          alert('Error adding award: ' + data.message);
        }
      })
      .catch(error => console.error('Error adding award:', error));
    }
  
    window.deleteAward = function(awardId) {
      fetch('http://localhost:8080/movie-webapp-1.00/award-delete', {
        method: 'DELETE'
      })
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          loadAwardsList();
        } else {
          alert('Error deleting award: ' + data.message);
        }
      })
      .catch(error => console.error('Error deleting award:', error));
    };

    // script.js
    document.addEventListener('DOMContentLoaded', () => {
    const navToggle = document.querySelector('.nav-toggle');
    const navLinks = document.querySelector('.nav-links');

    navToggle.addEventListener('click', () => {
        navLinks.classList.toggle('expanded');
    });
});
    /*
    const inputs = document.querySelectorAll('input');

    inputs.forEach(input => {
        input.addEventListener('input', () => {
            if (input.value.length > 0) {
                input.placeholder = '';
            } else {
                input.placeholder = input.getAttribute('placeholder');
            }
        });
    });
*/
    $(".form")
        .find("input, textarea")
        .on("keyup blur focus", function (e) {
            var $this = $(this),
                label = $this.prev("label");

            if (e.type === "keyup") {
                if ($this.val() === "") {
                    label.removeClass("active highlight");
                } else {
                    label.addClass("active highlight");
                }
            } else if (e.type === "blur") {
                if ($this.val() === "") {
                    label.removeClass("active highlight");
                } else {
                    label.removeClass("highlight");
                }
            } else if (e.type === "focus") {
                if ($this.val() === "") {
                    label.removeClass("highlight");
                } else if ($this.val() !== "") {
                    label.addClass("highlight");
                }
            }
        });

    $(".tab a").on("click", function (e) {
        e.preventDefault();

        $(this).parent().addClass("active");
        $(this).parent().siblings().removeClass("active");

        target = $(this).attr("href");

        $(".tab-content > div").not(target).hide();

        $(target).fadeIn(600);
    });

});
