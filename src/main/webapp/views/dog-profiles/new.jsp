<h1>DOGS for DAYS!!!</h1>

    <form action="/dogs" method="post">
      <div>
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" value="" />
      </div>
      <div>
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" value="" />
      </div>
      <div>
        <label for="breed">Breed</label>
        <select name="breed">
          <option value=""></option>
          <option value="Pug">Pug</option>
          <option value="Frenchie">Frenchie</option>
          <option value="Lab">Lab</option>
        </select>
      </div>
      <div>
        <label for="photoUrl">Photo URL</label>
        <input type="text" name="photoUrl" />
      </div>
        <div>
          <p>Male/Female</p>
          <div>
          <input type="radio" id="female" name="sex" value="female">
            <label for="female">Female</label>
          </div>
          <div>
          <input type="radio" id="male" name="sex" value="male">
          <label for="male">Male</label>
          </div>
        </div>

      <input type="submit" value="Add Dog" />
    </form>












